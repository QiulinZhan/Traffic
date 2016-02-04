package com.example.qiulin.traffic.adapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.qiulin.traffic.R;
import com.example.qiulin.traffic.beans.Driver;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import java.util.List;

/**
 * Created by qiulin on 2015/1/20 0020.
 */
public class DriverListAdapter extends RecyclerView.Adapter<DriverListAdapter.ViewHolder> {
    private List<Driver> driverList;
    private Context context;
    private Drawable icon;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public DriverListAdapter(Context context, List<Driver> driverList) {
        this.driverList = driverList;
        this.context = context;
        this.icon = new IconicsDrawable(context, FontAwesome.Icon.faw_user).color(Color.GRAY).sizeDp(24);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.driverlist_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Driver driver = driverList.get(position);
        holder.textView.setText(driver.getName());
        holder.imageView.setImageDrawable(icon);
    }

    @Override
    public int getItemCount() {
        return null ==  driverList? 0 : driverList.size();
    }
}
