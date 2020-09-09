package cn.itcast.ssm.domain;

import cn.itcast.ssm.util.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class SysLog implements Serializable {

    private String id;
    private String visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executeTime;
    private String method;
    private String visitTimeStr;

    public String getId() {
        if(id == null) {
            id = UUID.randomUUID().toString().replace("-", "");
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitTime() {

        return visitTime;
    }

    public void setVisitTime(String time) {
        this.visitTime = time;
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

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executeTime=" + executeTime +
                ", method='" + method + '\'' +
                '}';
    }
}
