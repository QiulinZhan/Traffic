package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.qiulin.traffic.beans.Car;

public class CarViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.car_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarViewActivity.this.onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        TextView carNo = (TextView) findViewById(R.id.carNo);
        TextView carType = (TextView) findViewById(R.id.carType);
        TextView carOwner = (TextView) findViewById(R.id.carOwner);
        TextView kilometers = (TextView) findViewById(R.id.kilometers);
        TextView bearerNumber = (TextView) findViewById(R.id.bearerNumber);
        TextView annualInspectionTime = (TextView) findViewById(R.id.annualInspectionTime);
        Car car = (Car)getIntent().getParcelableExtra("car");
        carNo.setText(car.getCarNo());
        carType.setText(car.getCarType());
        carOwner.setText(car.getCarOwner());
        kilometers.setText(car.getKilometers());
        bearerNumber.setText(car.getBearerNumber());
        annualInspectionTime.setText(car.getAnnualInspectionTime());
    }
    public static void launch(Activity activity, Object car) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, CarViewActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("car", (Car) car);
        intent.putExtras(bundle);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.search:
                    break;
            }
            if(!msg.equals("")) {
                Toast.makeText(CarViewActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.driver_menu, menu);
        return true;
    }
}
