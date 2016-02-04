package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.qiulin.traffic.utils.Utils;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class PassengerFormActivity extends AppCompatActivity {
    private ImageButton mFabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passengerform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("客运登记");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassengerFormActivity.this.onBackPressed();
            }
        });
        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_floppy_o).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Utils.configureFab(mFabButton);
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, PassengerFormActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
