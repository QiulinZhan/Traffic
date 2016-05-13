package com.example.qiulin.traffic.utils.okhttputils.callback;

import java.io.IOException;

import okhttp3.Response;
public abstract class StringCallback extends AbsCallback<String> {

    @Override
    public String parseNetworkResponse(Response response) {
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
