package com.example.qiulin.traffic.utils.okhttputils.callback;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhanqiulin on 2016/5/13.
 */
public class BeanCallBack<T> extends AbsCallback<T>{


    @Override
    public T parseNetworkResponse(Response response) throws IOException {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            //如果用户写了泛型，就会进入这里，否者不会执行
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type beanType = parameterizedType.getActualTypeArguments()[0];
            if (beanType == String.class) {
                //如果是String类型，直接返回字符串
                return (T) response.body().string();
            } else {
                //如果是 Bean List Map ，则解析完后返回
                return new Gson().fromJson(response.body().string(), beanType);
            }
        } else {
            //如果没有写泛型，直接返回Response对象
            return (T) response;
        }
    }

    @Override
    public void onResponse(boolean isFromCache, T t, Request request, @Nullable Response response) throws JSONException {

    }
}
