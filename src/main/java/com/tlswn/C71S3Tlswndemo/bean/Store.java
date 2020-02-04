package com.tlswn.C71S3Tlswndemo.bean;

public class Store {
    private Integer sid;

    private String sname;

    private String slogo;

    private Integer aaid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSlogo() {
        return slogo;
    }

    public void setSlogo(String slogo) {
        this.slogo = slogo == null ? null : slogo.trim();
    }

    public Integer getAaid() {
        return aaid;
    }

    public void setAaid(Integer aaid) {
        this.aaid = aaid;
    }
}