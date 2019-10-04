package com.blog.blogs.model;

public class User {
    private Long uid;
    private String uname;
    private String ubio;
    private String uavatar_url;
    private String uemail;
    private Long gmtCreate;
    private Long gmtModified;
    private String token;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUbio() {
        return ubio;
    }

    public void setUbio(String ubio) {
        this.ubio = ubio;
    }

    public String getUavatar_url() {
        return uavatar_url;
    }

    public void setUavatar_url(String uavatar_url) {
        this.uavatar_url = uavatar_url;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
