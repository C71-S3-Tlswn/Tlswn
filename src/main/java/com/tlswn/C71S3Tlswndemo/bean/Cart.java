package com.tlswn.C71S3Tlswndemo.bean;

public class Cart {
    private Integer ccid;

    private Integer count;

    private Double price;

    private Integer uid;

    private Integer cid;

    private String ctemp;

    private Integer ctemp2;

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCtemp() {
        return ctemp;
    }

    public void setCtemp(String ctemp) {
        this.ctemp = ctemp == null ? null : ctemp.trim();
    }

    public Integer getCtemp2() {
        return ctemp2;
    }

    public void setCtemp2(Integer ctemp2) {
        this.ctemp2 = ctemp2;
    }
}