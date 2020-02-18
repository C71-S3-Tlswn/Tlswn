package com.tlswn.C71S3Tlswndemo.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Cart implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1603630310338762706L;

	private Integer ccid;

    private Integer count;

    private Double price;

    private Integer uid;

    private Integer cid;

    private String ctemp;

    private Integer ctemp2;
    
    private Commodity commodity;
    
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

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