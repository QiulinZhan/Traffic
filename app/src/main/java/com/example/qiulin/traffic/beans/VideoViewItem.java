package com.example.qiulin.traffic.beans;

import android.graphics.drawable.Drawable;

public class VideoViewItem implements Comparable<Object> {
    private String name;
    private int index;
    private int imageId;
    public VideoViewItem(String name, int index, int imageId) {
        this.name = name;
        this.index = index;
        this.imageId = imageId;
    }
    public VideoViewItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public int compareTo(Object o) {
        VideoViewItem f = (VideoViewItem) o;
        return getName().compareTo(f.getName());
    }

    @Override
    public String toString() {
        return getName();
    }

}