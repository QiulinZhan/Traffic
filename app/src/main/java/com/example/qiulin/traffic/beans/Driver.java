package com.example.qiulin.traffic.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class Driver implements Parcelable{
    private String id;
    private String name;
    private String birthday;
    private String sex;
    private String idno;
    private String createTime;

    public Driver(String id, String name, String birthday, String sex, String idno, String createTime) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.idno = idno;
        this.createTime = createTime;
    }

    protected Driver(Parcel in) {
        id = in.readString();
        name = in.readString();
        birthday = in.readString();
        sex = in.readString();
        idno = in.readString();
        createTime = in.readString();
    }

    public static final Creator<Driver> CREATOR = new Creator<Driver>() {
        @Override
        public Driver createFromParcel(Parcel in) {
            return new Driver(in);
        }

        @Override
        public Driver[] newArray(int size) {
            return new Driver[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(birthday);
        dest.writeString(sex);
        dest.writeString(idno);
        dest.writeString(createTime);
    }
}
