package com.example.qiulin.traffic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qiulin.traffic.R;
import com.example.qiulin.traffic.beans.Alarm;
import com.example.qiulin.traffic.beans.Dangerous;

import java.util.List;

/**
 * Created by qiulin on 2015/1/19 0019.
 */
public class DangerousListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Dangerous> list;
    public DangerousListAdapter(Context context, List<Dangerous> list) {
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
            view = layoutInflater.inflate(R.layout.alarmlist_item, parent, false);
        } else {
            view = convertView;
        }
        TextView time = (TextView) view.findViewById(R.id.time);
        TextView type = (TextView) view.findViewById(R.id.type);
        TextView  name = (TextView) view.findViewById(R.id.name);
        TextView content = (TextView) view.findViewById(R.id.content);
        Dangerous item = list.get(position);
        //获取自定义的类实例
        time.setText(item.getCheckTime());
        type.setText(item.getDjmj());
        name.setText(item.getDriverName());
        content.setText(item.getBz());
        return view;
    }
}
