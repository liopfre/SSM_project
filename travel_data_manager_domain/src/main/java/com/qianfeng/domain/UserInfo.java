package com.qianfeng.domain;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/8 16:51
 * 描述：TODO
 */
public class UserInfo {
    String id;
    String email;
    String username;
    String password;
    String phoneNum;
    int status;
    String statusStr;
    List<Role> roles;

    public UserInfo() {
    }

    public UserInfo(String id, String email, String username, String password, String phoneNum, int status, String statusStr, List<Role> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.status = status;
        this.statusStr = statusStr;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status==1){
            statusStr="开启";
        }else if (status==0){
            statusStr="关闭";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
