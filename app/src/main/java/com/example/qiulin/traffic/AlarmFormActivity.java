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

import com.example.qiulin.traffic.beans.Alarm;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class AlarmFormActivity extends AppCompatActivity {
    private ImageButton mFabButton;
    private static Gson gson = new Gson();
    MaterialEditText alarmStart,type,name,sex,tel,address,content,status,instructions,feedback,police,
            alarmEnd,weather,accident,reason,pavement,carType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmform);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("接处警明细");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmFormActivity.this.onBackPressed();
            }
        });
        alarmStart = (MaterialEditText) findViewById(R.id.alarmStart);
        type = (MaterialEditText) findViewById(R.id.type);
        name = (MaterialEditText) findViewById(R.id.name);
        sex = (MaterialEditText) findViewById(R.id.sex);
        tel = (MaterialEditText) findViewById(R.id.tel);
        address = (MaterialEditText) findViewById(R.id.address);
        content = (MaterialEditText) findViewById(R.id.content);
        status = (MaterialEditText) findViewById(R.id.status);
        instructions = (MaterialEditText) findViewById(R.id.instructions);
        feedback = (MaterialEditText) findViewById(R.id.feedback);
        police = (MaterialEditText) findViewById(R.id.police);
        alarmEnd = (MaterialEditText) findViewById(R.id.alarmEnd);
        weather = (MaterialEditText) findViewById(R.id.weather);
        accident = (MaterialEditText) findViewById(R.id.accident);
        reason = (MaterialEditText) findViewById(R.id.reason);
        pavement = (MaterialEditText) findViewById(R.id.pavement);
        carType = (MaterialEditText) findViewById(R.id.carType);

        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_floppy_o).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = DataUtil.getd(AlarmFormActivity.this, "Alarm");
                List<Alarm> list = new ArrayList<>();
                if(data != null){
                    list = gson.fromJson(data, new TypeToken<List<Alarm>>() {
                    }.getType());
                }
                Alarm d = new Alarm();
                String temp = alarmStart.getText().toString();
                if(StringUtils.isBlank(temp)){
                    alarmStart.setError("不能为空");
                    return;
                }
                 d.setAlarmStart(alarmStart.getText().toString());
                d.setType(type.getText().toString());
                d.setName(name.getText().toString());
                d.setTel(tel.getText().toString());
                d.setAddress(address.getText().toString());
                d.setContent(content.getText().toString());
                d.setStatus(status.getText().toString());
                d.setInstructions(instructions.getText().toString());
                d.setFeedback(feedback.getText().toString());
                d.setPolice(police.getText().toString());
                d.setAlarmEnd(alarmEnd.getText().toString());
                d.setWeather(weather.getText().toString());
                d.setAccident(accident.getText().toString());
                d.setReason(reason.getText().toString());
                d.setPavement(pavement.getText().toString());
                d.setCarType(carType.getText().toString());
                list.add(0,d);
                String str = gson.toJson(list);
                DataUtil.saved(AlarmFormActivity.this, str,"Alarm");
                AlarmListActivity.launch(AlarmFormActivity.this);
            }
        });
        Utils.configureFab(mFabButton);
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, AlarmFormActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
