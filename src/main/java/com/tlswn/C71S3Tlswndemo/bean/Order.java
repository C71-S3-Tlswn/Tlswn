package com.tlswn.C71S3Tlswndemo.bean;

import java.util.Date;

public class Order {
    private Integer oid;

    private Integer uid;

    private Integer cid;

    private String oaddr;

    private String otel;

    private Date ordertime;

    private Date delivetime;

    private Date arrivetime;

    private String ps;

    private Double oprice;

    private Integer pstatus;

    private Integer status;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public String getOaddr() {
        return oaddr;
    }

    public void setOaddr(String oaddr) {
        this.oaddr = oaddr == null ? null : oaddr.trim();
    }

    public String getOtel() {
        return otel;
    }

    public void setOtel(String otel) {
        this.otel = otel == null ? null : otel.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getDelivetime() {
        return delivetime;
    }

    public void setDelivetime(Date delivetime) {
        this.delivetime = delivetime;
    }

    public Date getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}