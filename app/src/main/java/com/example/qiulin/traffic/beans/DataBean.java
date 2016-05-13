package com.example.qiulin.traffic.beans;

/**
 * Created by zhanqiulin on 2016/5/13.
 */
public class DataBean <T> {
    private Integer code;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
