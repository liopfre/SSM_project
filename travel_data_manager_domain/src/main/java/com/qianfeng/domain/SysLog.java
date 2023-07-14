package com.qianfeng.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：YoriStar
 * 时间：2023/7/10 20:34
 * 描述：TODO
 */
public class SysLog {
    String id;
    Date visitTime;
    String username;
    String ip;
    String url;
    long executionTime;
    String method;
    String visitTimeStr;

    public SysLog(String id, Date visitTime, String username, String ip, String url, long executionTime, String method) {
        this.id = id;
        this.visitTime = visitTime;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.executionTime = executionTime;
        this.method = method;
    }

    public SysLog(String id, Date visitTime, String username, String ip, String url, long executionTime, String method, String visitTimeStr) {
        this.id = id;
        this.visitTime = visitTime;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.executionTime = executionTime;
        this.method = method;
        this.visitTimeStr = visitTimeStr;
    }

    public SysLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVisitTimeStr() {
        if (visitTime!=null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            visitTimeStr = simpleDateFormat.format(visitTime);
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {

    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", visitTime=" + visitTime +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }
}
