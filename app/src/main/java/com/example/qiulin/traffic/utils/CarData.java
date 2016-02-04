package com.example.qiulin.traffic.utils;

import com.example.qiulin.traffic.beans.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanqiulin on 2016/2/3.
 */
public class CarData {
    private static Map<String, Car> data = new HashMap<String, Car>();
    static{
        data.put("1", new Car("1","吉A01021","A1","张云峰","20131","30","2015-05-06"));
        data.put("吉A01021", new Car("1","吉A01021","A1","张云峰","20131","30","2015-05-06"));
        data.put("吉A01022", new Car("2","吉A01022","C2","李伟","13595","5","2015-05-06"));
        data.put("吉A01023", new Car("3","吉A01023","C2","白景琦","6000","4","2015-05-06"));
        data.put("吉A01024", new Car("4","吉A01024","C2","李牧","30269","5","2015-05-06"));
        data.put("吉A01025", new Car("5","吉A01025","C2","王德利","45952","2","2015-05-06"));
        data.put("吉A01026", new Car("6","吉A01026","C2","邵晓吉","30000","5","2015-05-06"));
        data.put("吉A01027", new Car("7","吉A01027","C2","文泓宇","5000","5","2015-05-06"));
        data.put("吉A01028", new Car("8","吉A01028","C2","刘金辉","3000","5","2015-05-06"));
        data.put("吉A01029", new Car("9","吉A01029","A1","黄德迪","10005","30","2015-05-06"));
        data.put("吉A01031", new Car("10","吉A01029","A1","黄几道","10405","30","2015-05-06"));
    }
    public static Car getCar(String no){
        if(data.containsKey(no)){
            return data.get(no);
        }else{
            return null;
        }
    }
}
