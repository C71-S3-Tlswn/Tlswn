package com.tlswn.C71S3Tlswndemo.vo;

import java.io.Serializable;

public class StatisticsVo implements Serializable{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3280148916618373676L;

	private Integer count;
	
	private Double price;
	
	private Integer cid;
	
	private Integer vid;
	
	private String vname;

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

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}
	
}
