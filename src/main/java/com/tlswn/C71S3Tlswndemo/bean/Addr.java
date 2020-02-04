package com.tlswn.C71S3Tlswndemo.bean;

public class Addr {
    private Integer aid;

    private Integer uid;

    private String addr;

    private String aname;

    private String atel;

    private Integer astatus;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getAtel() {
        return atel;
    }

    public void setAtel(String atel) {
        this.atel = atel == null ? null : atel.trim();
    }

    public Integer getAstatus() {
        return astatus;
    }

    public void setAstatus(Integer astatus) {
        this.astatus = astatus;
    }
}