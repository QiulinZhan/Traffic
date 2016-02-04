package com.example.qiulin.traffic;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.example.qiulin.traffic.adapter.GridViewAdapter;
import com.example.qiulin.traffic.beans.Car;
import com.example.qiulin.traffic.beans.Driver;
import com.example.qiulin.traffic.utils.CarData;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.DriverData;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class MainActivity extends AppCompatActivity {
    private GridView mGridView;
    private GridViewAdapter mAdapter;
    private SysData data;
    private Handler handler = new Handler();
    private Thread mThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        LinearLayout mDrawerList = (LinearLayout) findViewById(R.id.drawerList);
        mDrawerList.findViewById(R.id.drawer_opensource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataUtil.clearData(MainActivity.this);
                LoginActivity.launch(MainActivity.this);
            }
        });
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                try {
                    JSONObject obj = new JSONObject(msg.obj.toString());
                    MaterialDialog dialog = new MaterialDialog.Builder(MainActivity.this)
                            .title("驾驶员信息")
                            .customView(R.layout.driver_view, false)
                            .positiveText("关闭")
                            .build();
                    View view = dialog.getCustomView();
                    MaterialEditText edit1 = (MaterialEditText) view.findViewById(R.id.name);
                    edit1.setText(obj.getString("name"));
                    MaterialEditText edit2 = (MaterialEditText) view.findViewById(R.id.no);
                    edit2.setText(obj.getString("no"));
                    dialog.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        mGridView = (GridView) findViewById(R.id.grid);
        data = (SysData) getApplication();
        mAdapter = new GridViewAdapter(MainActivity.this,data.getMainMenuList());
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        VideoListActivity.launch(MainActivity.this);
                        break;
                    case 1:
                        PhotoListActivity.launch(MainActivity.this);
                        break;
                    case 2:
                        new MaterialDialog.Builder(MainActivity.this)
                                .title("查询驾驶员信息")
                                .theme(Theme.LIGHT)
                                .customView(R.layout.search_driver_view, false)
                                .onNegative(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        MaterialEditText text = (MaterialEditText) dialog.findViewById(R.id.searchDriverNo);
                                        String driverNo = text.getText().toString();
                                        dialog.dismiss();
                                        if (StringUtils.isEmpty(driverNo)) {
                                            new AlertDialogWrapper.Builder(MainActivity.this)
                                                    .setTitle("错误")
                                                    .setMessage("驾驶证号不能为空")
                                                    .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog1, int which1) {
                                                            dialog1.dismiss();
                                                        }
                                                    }).show();
                                        } else {
                                            getDriver(driverNo);
                                        }
                                    }
                                })
                                .positiveText("取消")
                                .negativeText("确定")
                                .show();
                        break;
                    case 3:
                        new MaterialDialog.Builder(MainActivity.this)
                                .title("查询车辆信息")
                                .theme(Theme.LIGHT)
                                .customView(R.layout.search_car_view, false)
                                .onNegative(new MaterialDialog.SingleButtonCallback() {
                                    @Override
                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                        MaterialEditText text = (MaterialEditText) dialog.findViewById(R.id.searchNo);
                                        String carNo = text.getText().toString();
                                        dialog.dismiss();
                                        if (StringUtils.isEmpty(carNo)) {
                                            new AlertDialogWrapper.Builder(MainActivity.this)
                                                    .setTitle("错误")
                                                    .setMessage("车牌号不能为空")
                                                    .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog1, int which1) {
                                                            dialog1.dismiss();
                                                        }
                                                    }).show();
                                        } else {
                                            getCar(carNo);
                                        }
                                    }
                                })
                                .positiveText("取消")
                                .negativeText("确定")
                                .show();
                        break;
                    case 4:
                        SelectPicPopupWindow.launch(MainActivity.this);
                        break;
                    case 5:
                        SelectPicPopupVideo.launch(MainActivity.this);
                        break;
                    case 6:
                        AlarmListActivity.launch(MainActivity.this);
                        break;
                    case 7:
                        DangerousListActivity.launch(MainActivity.this);
                        break;
                    case 8:
                        PassengerListActivity.launch(MainActivity.this);
                        break;
                }
            }
        });
        mGridView.setAdapter(mAdapter);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void getCar(String carNo){
        try{
            new HttpTask().execute(carNo,"1");
        }catch(Exception e){

        }

    }
    private void getDriver(String driverNo){
        try{
            new HttpTask().execute(driverNo,"2");
        }catch(Exception e){

        }
    }

    private class HttpTask extends AsyncTask<String, Void, Object> {
        private String type;
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Object doInBackground(String... params) {
            type = params[1];
            if("1".equals(type)){
                Car car = CarData.getCar(params[0]);
                return car;
            }else{
                Driver driver = DriverData.getDriver(params[0]);
                return driver;
            }

//            String url = "http://" + String.valueOf(DataUtil.getProp(MainActivity.this, "ip1", "conf")) +"/traffic/car/findcar.do";
//            try {
//                RestTemplate restTemplate = new RestTemplate();
//                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//                restTemplate.getForObject(url, String.class).toString();
//                return car;
//            } catch (HttpClientErrorException e) {
//                e.printStackTrace();
//            } catch (ResourceAccessException e) {
//                e.printStackTrace();
////                return "网络链接失败";S
//            } catch (Exception e){
//                e.printStackTrace();
//            }
        }

        @Override
        protected void onPostExecute(Object obj) {
            if("1".equals(type)){
                if(obj == null){
                    new AlertDialogWrapper.Builder(MainActivity.this)
                            .setTitle("错误")
                            .setMessage("没有找到该记录")
                            .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog1, int which1) {
                                    dialog1.dismiss();
                                }
                            }).show();
                }else{
                    CarViewActivity.launch(MainActivity.this, obj);
                }
            }else{
                if(obj == null){
                    new AlertDialogWrapper.Builder(MainActivity.this)
                            .setTitle("错误")
                            .setMessage("没有找到该记录")
                            .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog1, int which1) {
                                    dialog1.dismiss();
                                }
                            }).show();
                }else{
                    DriverViewActivity.launch(MainActivity.this, obj);
                }
            }
        }
    }
}