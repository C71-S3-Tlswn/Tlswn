package com.tlswn.C71S3Tlswndemo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Commodity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private Integer cid;

    private String cname;

    private String cphoto;

    private Double mprice;

    private Double cprice;

    private Date cBtime;

    private Integer hot;

    private Date cEtime;

    private String csize;

    private Integer cnum;

    private String cdescride;

    private Integer tid;

    private Integer sid;

    private String temp;

    private Integer temp2;
    
    private Type type;
    
    private List<Stock> stockit;

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

    public String getCsize() {
        return csize;
    }

    public void setCsize(String csize) {
        this.csize = csize == null ? null : csize.trim();
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    public Integer getTemp2() {
        return temp2;
    }

    public void setTemp2(Integer temp2) {
        this.temp2 = temp2;
    }

	public List<Stock> getStockit() {
		return stockit;
	}

	public void setStockit(List<Stock> stockit) {
		this.stockit = stockit;
	}
}