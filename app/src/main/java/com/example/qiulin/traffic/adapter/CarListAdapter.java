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
import com.example.qiulin.traffic.beans.Car;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import java.util.List;

/**
 * Created by qiulin on 2015/1/20 0020.
 */
public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {
    private List<Car> carList;
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

    public CarListAdapter(Context context, List<Car> carList) {
        this.carList = carList;
        this.context = context;
        this.icon = new IconicsDrawable(context, FontAwesome.Icon.faw_car).color(Color.GRAY).sizeDp(24);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carlist_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.textView.setText(car.getCarNo());
        holder.imageView.setImageDrawable(icon);
    }

    @Override
    public int getItemCount() {
        return null ==  carList? 0 : carList.size();
    }
}
