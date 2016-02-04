package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qiulin.traffic.adapter.AlarmListAdapter;
import com.example.qiulin.traffic.beans.Alarm;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiulin on 2015/1/20 0020.
 */
public class AlarmListActivity extends AppCompatActivity {
    private static Gson gson = new Gson();
    private ListView listView;
    private AlarmListAdapter mAdapter;
    private static List<Alarm> alarmList;
    private ImageButton mFabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmlist);
        alarmList = getData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.call_police_frag);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmListActivity.this.onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        listView = (ListView) findViewById(R.id.list);
        mAdapter = new AlarmListAdapter(AlarmListActivity.this,alarmList);
        listView.setAdapter(mAdapter);
        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_plus).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmFormActivity.launch(AlarmListActivity.this);
            }
        });
        Utils.configureFab(mFabButton);

    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, AlarmListActivity.class);
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
                Toast.makeText(AlarmListActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.driver_menu, menu);
        return true;
    }
    private List<Alarm> getData() {
        String data = DataUtil.getd(AlarmListActivity.this, "Alarm");
        List<Alarm> list = new ArrayList<>();
        if(data != null){
            list = gson.fromJson(data, new TypeToken<List<Alarm>>() {
            }.getType());
        }
        return list;
    }
}
