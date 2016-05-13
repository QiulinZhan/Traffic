package com.example.qiulin.traffic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.qiulin.traffic.beans.vo.User;

import java.util.Map;

/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class DataUtil extends Activity{
    private static SharedPreferences preferences;
    private static final String default_url = "192.168.1.165:8092";
    public static void saveDate(Context context, User user) {
        preferences = context.getSharedPreferences("info", Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString("id", user.getID());
        editor.putString("expiresTime", "9999999999");
        editor.putString("openid", user.getUSERNAME());
        editor.commit();
    }
    public static void saveConf(Context context, Map params) {
        preferences = context.getSharedPreferences("conf", Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        for(Object key : params.keySet()){
            editor.putString(String.valueOf(key),String.valueOf(params.get(key)));
        }
        editor.commit();
    }
    public static User getDate(Context context)
    {
        User user = null;
        preferences = context.getSharedPreferences("info", Context.MODE_PRIVATE);
        String id = preferences.getString("id", null);
        if(null != id && !"".equals(id)){
            user =  new User();
            user.setID(id);
            user.setUSERNAME(preferences.getString("userName", null));
            user.setNAME(preferences.getString("RealName", null));
        }
        return user;
    }
    public static Object getProp(Context context, String propName, String fileName)
    {
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Object obj = preferences.getString(propName,null);
        return obj;
    }
    public static String getUrl(Context context,String action)
    {
        String url = null;
        preferences = context.getSharedPreferences("conf", Context.MODE_PRIVATE);
        Object obj = preferences.getString("ip1",null);
        if(obj != null){
            url =  String.valueOf(obj);
        }else{
            url = default_url;
        }
        return "http://" + url  +"/server/" + action;
    }
    public static void clearData(Context context)
    {
        preferences = context.getSharedPreferences("info", Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
    public String getPropValue(String rootName, String propName, int mode){
        return getSharedPreferences(rootName, mode).getString(propName, "");
    }
    public static void saved(Context context, String data, String type) {
        preferences = context.getSharedPreferences(type, Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString("data",data );
        editor.commit();
    }
    public static String getd(Context context, String type) {
        preferences = context.getSharedPreferences(type, Context.MODE_PRIVATE);
        String data = preferences.getString("data", null);
        return data;
    }
}
