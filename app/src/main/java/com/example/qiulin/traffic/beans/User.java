package com.example.qiulin.traffic.beans;
import java.io.Serializable;
/**
 * Created by qiulin on 2015/1/16 0016.
 */
public class User extends com.example.qiulin.traffic.beans.vo.User implements Serializable{
    private String id;
    private String username;
    private String password;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return name;
    }

    public void setRealname(String realname) {
        this.name = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
