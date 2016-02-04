package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.qiulin.traffic.adapter.VideoListAdapter;
import com.example.qiulin.traffic.beans.VideoViewItem;
import com.example.qiulin.traffic.utils.CPResourceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiulin on 2015/1/22 0022.
 */
public class PhotoListActivity extends AppCompatActivity {
    private GridView mGridView;
    private VideoListAdapter mAdapter;
    private static List<VideoViewItem> videoList;
    private Handler handler = new Handler();
    private ExecutorService executorService = Executors.newFixedThreadPool(11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.photo_frag);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoListActivity.this.onBackPressed();
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        mGridView = (GridView) findViewById(R.id.grid);
        videoList = new ArrayList<>();
        mAdapter = new VideoListAdapter(PhotoListActivity.this, videoList);
        mGridView.setAdapter(mAdapter);
        mGridView.setSelector(R.drawable.button_rect_list_normal);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PhotoListActivity.this, VideoPlayActivity.class);
//                startActivity(intent);
            }
        });
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                VideoViewItem item = (VideoViewItem) msg.obj;
                videoList.add(item);
                mAdapter.notifyDataSetChanged();
            }
        };

        for(int i = 0; i < 11; i++){
            final int index = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        VideoViewItem item = new VideoViewItem("视频" + index, index, CPResourceUtil.getDrawableId(PhotoListActivity.this, "ds" + index));
                        Message msg = new Message();
                        msg.obj = item;
                        msg.setTarget(handler);
                        handler.sendMessage(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, PhotoListActivity.class);
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
                Toast.makeText(PhotoListActivity.this, msg, Toast.LENGTH_SHORT).show();
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
