package com.example.qiulin.traffic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.qiulin.traffic.beans.User;

import java.util.Map;

/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class DataUtil extends Activity{
    private static SharedPreferences preferences;
    public static void saveDate(Context context, User user) {
        preferences = context.getSharedPreferences("info", Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString("id", user.getId());
        editor.putString("expiresTime", user.getRealName());
        editor.putString("openid", user.getUserName());
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
            user.setId(id);
            user.setUserName(preferences.getString("userName",null));
            user.setRealName(preferences.getString("RealName",null));
        }
        return user;
    }
    public static Object getProp(Context context, String propName, String fileName)
    {
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Object obj = preferences.getString(propName,null);
        return obj;
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
