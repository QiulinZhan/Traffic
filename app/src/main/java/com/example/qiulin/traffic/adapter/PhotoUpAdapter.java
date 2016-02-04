package com.example.qiulin.traffic.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiulin.traffic.R;
import com.example.qiulin.traffic.beans.GridViewItem;

import java.util.List;

/**
 * Created by qiulin on 2015/1/19 0019.
 */
public class PhotoUpAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<GridViewItem> list;
    public PhotoUpAdapter(Context context, List<GridViewItem> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return this.list != null ? this.list.size(): 0 ;
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.gridview_item, parent, false);
        } else {
            view = convertView;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.countryImage);
        TextView textView = (TextView) view.findViewById(R.id.countryName);
        GridViewItem item = list.get(position);
            //获取自定义的类实例
        imageView.setImageDrawable(item.getIcon());
        textView.setText(item.getName());
        return view;
    }
}
