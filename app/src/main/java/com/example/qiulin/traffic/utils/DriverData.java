package com.example.qiulin.traffic.utils;

import com.example.qiulin.traffic.beans.Driver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanqiulin on 2016/2/3.
 */
public class DriverData {
    private static Map<String, Driver> data = new HashMap<>();
    static{
        data.put("220110197506061102", new Driver("1","张云峰","1975-06-06","男","220110197506061102","2013-05-06"));
        data.put("1", new Driver("1","张云峰","1975-06-06","男","220110197506061102","2013-05-06"));
        data.put("220110197506061101", new Driver("2","李伟","1975-06-06","男","220110197506061101","2010-06-06"));
        data.put("220110197506061103", new Driver("3","白景琦","1975-06-06","男","220110197506061103","2013-05-06"));
        data.put("220110197506061104", new Driver("4","李牧","1975-06-06","男","220110197506061104","2013-05-06"));
        data.put("220110197506061105", new Driver("5","王德利","1985-06-06","男","220110197506061105","2015-05-06"));
        data.put("220110197506061106", new Driver("6","黄德迪","1995-06-06","男","220110197506061106","2000-05-06"));
        data.put("220110197506061107", new Driver("7","邵晓吉","1977-06-06","男","220110197506061107","2014-05-06"));
        data.put("220110197506061108", new Driver("8","文泓宇","1968-06-06","男","220110197506061108","2014-05-06"));
        data.put("220110197506061109", new Driver("9","黄几道","1989-06-06","男","220110197506061109","2013-05-06"));
    }
    public static Driver getDriver(String no){
        if(data.containsKey(no)){
            return data.get(no);
        }else{
            return null;
        }
    }
}
