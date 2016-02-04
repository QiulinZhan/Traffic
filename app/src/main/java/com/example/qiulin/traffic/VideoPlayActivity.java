package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by qiulin on 2015/1/26 0026.
 */
public class VideoPlayActivity extends Activity{
    MediaPlayer player;
    SurfaceView surface;
    SurfaceHolder surfaceHolder;
    Button play,pause,stop;
    VideoView video;
    MediaController mediaco;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        video = (VideoView)findViewById(R.id.video);
        mediaco = new MediaController(this);
            //VideoView与MediaController进行关联
        video.setVideoURI(Uri.parse("android.resource://com.example.qiulin.traffic/" + R.raw.demo));
        video.setMediaController(mediaco);
        mediaco.setMediaPlayer(video);
        //让VideiView获取焦点
        video.requestFocus();
        video.start();
//        play=(Button)findViewById(R.id.button1);
//        pause=(Button)findViewById(R.id.button2);
//        stop=(Button)findViewById(R.id.button3);
//        surface=(SurfaceView)findViewById(R.id.surface);
//        surfaceHolder=surface.getHolder();   //SurfaceHolder是SurfaceView的控制接口
//        surfaceHolder.addCallback(this);     //因为这个类实现了SurfaceHolder.Callback接口，所以回调参数直接this
//        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);  //Surface类型
//
//        play.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                player.start();
//            }});
//        pause.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                player.pause();
//            }});
//        stop.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                player.stop();
//            }});
    }

//    @Override
//    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder arg0) {
////必须在surface创建后才能初始化MediaPlayer,否则不会显示图像
//        player = MediaPlayer.create(this, R.raw.demo);
//        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        player.setDisplay(surfaceHolder);
//        //设置显示视频显示在SurfaceView上
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder arg0) {
//        // TODO Auto-generated method stub
//
//    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
//        Activity销毁时停止播放，释放资源。不做这个操作，即使退出还是能听到视频播放的声音
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, VideoPlayActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
