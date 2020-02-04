package com.tlswn.C71S3Tlswndemo.bean;

import java.util.Date;

public class Evaluate {
    private Integer eid;

    private Integer uid;

    private String content;

    private String eimg;

    private Date etime;

    private Integer cid;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getEimg() {
        return eimg;
    }

    public void setEimg(String eimg) {
        this.eimg = eimg == null ? null : eimg.trim();
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}