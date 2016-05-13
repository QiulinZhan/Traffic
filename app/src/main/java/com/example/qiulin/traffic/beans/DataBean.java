package com.example.qiulin.traffic.beans;

import java.util.List;

/**
 * Created by zhanqiulin on 2016/5/13.
 */
public class DataBean <T> {
    private Integer code;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
