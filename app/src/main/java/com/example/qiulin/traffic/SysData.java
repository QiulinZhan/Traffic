package com.example.qiulin.traffic;

/**
 * Created by qiulin on 2015/1/16 0016.
 */
import android.app.Application;
import android.graphics.Color;

import com.example.qiulin.traffic.beans.GridViewItem;
import com.example.qiulin.traffic.beans.User;
import com.example.qiulin.traffic.utils.okhttputils.OkHttpUtils;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import java.util.ArrayList;
import java.util.List;

public class SysData extends Application{
    private User user;
    private static List <GridViewItem> mainMenuList;
    public List<GridViewItem> getMainMenuList() {
        return mainMenuList;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.video_frag), 0, new IconicsDrawable(this, FontAwesome.Icon.faw_youtube_play).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.photo_frag), 1,  new IconicsDrawable(this, FontAwesome.Icon.faw_picture_o).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.driver_frag), 2,  new IconicsDrawable(this, FontAwesome.Icon.faw_user).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.car_frag), 3,  new IconicsDrawable(this, FontAwesome.Icon.faw_car).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.up_photo_frag), 4,  new IconicsDrawable(this, FontAwesome.Icon.faw_upload).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.up_vidio_frag), 5,  new IconicsDrawable(this, FontAwesome.Icon.faw_video_camera).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.call_police_frag), 6,  new IconicsDrawable(this, FontAwesome.Icon.faw_bell).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.danger_frag), 7,  new IconicsDrawable(this, FontAwesome.Icon.faw_fire).color(Color.GRAY).actionBarSize()));
        mainMenuList.add(new GridViewItem(getResources().getString(R.string.pub_frag), 8,  new IconicsDrawable(this, FontAwesome.Icon.faw_bus).color(Color.GRAY).actionBarSize()));
        OkHttpUtils.init(this);
    }
}
