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

import com.example.qiulin.traffic.beans.Driver;

public class DriverViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.driver_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverViewActivity.this.onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        TextView name = (TextView) findViewById(R.id.name);
        TextView birthday = (TextView) findViewById(R.id.birthday);
        TextView sex = (TextView) findViewById(R.id.sex);
        TextView idno = (TextView) findViewById(R.id.idno);
        TextView createTime = (TextView) findViewById(R.id.createTime);
        Driver driver = (Driver) getIntent().getParcelableExtra("driver");
        name.setText(driver.getName());
        birthday.setText(driver.getBirthday());
        sex.setText(driver.getSex());
        idno.setText(driver.getIdno());
        createTime.setText(driver.getCreateTime());
    }
    public static void launch(Activity activity, Object driver) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, DriverViewActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("driver", (Driver) driver);
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
                Toast.makeText(DriverViewActivity.this, msg, Toast.LENGTH_SHORT).show();
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
