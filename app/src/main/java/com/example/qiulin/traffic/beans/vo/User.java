package com.example.qiulin.traffic.beans.vo;
import java.io.Serializable;

/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class User implements Serializable{
    private String ID;
    private String USERNAME;
    private String PASSWORD;
    private String NAME;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
