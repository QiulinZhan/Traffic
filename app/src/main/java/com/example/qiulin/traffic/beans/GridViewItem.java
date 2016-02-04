package com.example.qiulin.traffic.beans;

import android.graphics.drawable.Drawable;

public class GridViewItem implements Comparable<Object> {
    private String name;
    private int index;
    private Drawable icon;
    public GridViewItem(String name, int index, Drawable icon) {
        this.name = name;
        this.index = index;
        this.icon = icon;
    }
    public GridViewItem() {
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

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    @Override
    public int compareTo(Object o) {
        GridViewItem f = (GridViewItem) o;
        return getName().compareTo(f.getName());
    }

    @Override
    public String toString() {
        return getName();
    }

}