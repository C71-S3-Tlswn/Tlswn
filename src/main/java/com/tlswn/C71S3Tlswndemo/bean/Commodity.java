package com.tlswn.C71S3Tlswndemo.bean;

import java.util.Date;

public class Commodity {
    private Integer cid;

    private String cname;

    private String cphoto;

    private Double mprice;

    private Double cprice;

    private Date cBtime;

    private Integer hot;

    private Date cEtime;

    private Integer cnum;

    private String cdescride;

    private Integer tid;

    private Integer sid;
    
    private Type type;
    
    

    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCphoto() {
        return cphoto;
    }

    public void setCphoto(String cphoto) {
        this.cphoto = cphoto == null ? null : cphoto.trim();
    }

    public Double getMprice() {
        return mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    public Date getcBtime() {
        return cBtime;
    }

    public void setcBtime(Date cBtime) {
        this.cBtime = cBtime;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Date getcEtime() {
        return cEtime;
    }

    public void setcEtime(Date cEtime) {
        this.cEtime = cEtime;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getCdescride() {
        return cdescride;
    }

    public void setCdescride(String cdescride) {
        this.cdescride = cdescride == null ? null : cdescride.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}