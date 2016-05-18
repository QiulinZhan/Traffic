package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import com.example.qiulin.traffic.adapter.DangerousListAdapter;
import com.example.qiulin.traffic.beans.Dangerous;
import com.example.qiulin.traffic.beans.DataBean;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.Utils;
import com.example.qiulin.traffic.utils.okhttputils.OkHttpUtils;
import com.example.qiulin.traffic.utils.okhttputils.callback.BeanCallBack;
import com.example.qiulin.traffic.utils.okhttputils.request.PostRequest;
import com.google.gson.Gson;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qiulin on 2015/1/20 0020.
 */
public class DangerousListActivity extends AppCompatActivity {
    private static Gson gson = new Gson();
    private ListView listView;
    private DangerousListAdapter mAdapter;
    private static List<Dangerous> alarmList;
    private ImageButton mFabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerous);
        alarmList = getData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("危化品运输车登记信息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangerousListActivity.this.onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        listView = (ListView) findViewById(R.id.list);
        mAdapter = new DangerousListAdapter(DangerousListActivity.this,alarmList);
        listView.setAdapter(mAdapter);
        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_plus).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangerousFormActivity.launch(DangerousListActivity.this);
            }
        });
        Utils.configureFab(mFabButton);

    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, DangerousListActivity.class);
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
                Toast.makeText(DangerousListActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.driver_menu, menu);
        return true;
    }

    private List<Dangerous> getData() {
        String url = DataUtil.getUrl(DangerousListActivity.this,"dangerouslist");
        OkHttpUtils.post(url).tag(this)
                .params("rowCountOfOnePage","100")
                .mediaType(PostRequest.MEDIA_TYPE_PLAIN)//
                .execute(new BeanCallBack<DataBean<Dangerous>>() {
                    @Override
                    public void onResponse(boolean isFromCache, DataBean<Dangerous> data, Request request, @Nullable Response response) {
                        if(data.getCode() != null && data.getCode() == 0){
                            alarmList = data.getData();
                            listView = (ListView) findViewById(R.id.list);
                            mAdapter = new DangerousListAdapter(DangerousListActivity.this,alarmList);
                            listView.setAdapter(mAdapter);
                        }
                    }
                }, DangerousListActivity.this);
        return alarmList;
    }
}
