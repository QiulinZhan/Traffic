package com.example.qiulin.traffic.beans;
import java.io.Serializable;
/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class User implements Serializable{
    private String id;
    private String userName;
    private String realName;
    private String passWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
