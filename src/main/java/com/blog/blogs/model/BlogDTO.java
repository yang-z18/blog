package com.blog.blogs.model;

public class BlogDTO {
    private String bid;
    private Long uid;
    private String btitle;
    private String bcontent;
    private Long bCreateTime;
    private User user;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public Long getbCreateTime() {
        return bCreateTime;
    }

    public void setbCreateTime(Long bCreateTime) {
        this.bCreateTime = bCreateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
