package com.tlswn.C71S3Tlswndemo.vo;

import java.io.Serializable;
import java.util.Date;

public class NearWeekVo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1714102668723310120L;
	
	private Date ordertimes;
	
	 private Integer count;
	 
	 private Double price;
	 
	 private String vname;
	 
	 
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getOrdertimes() {
		return ordertimes;
	}
	public void setOrdertimes(Date ordertimes) {
		this.ordertimes = ordertimes;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	 @Override
		public String toString() {
			return "NearWeekVo [ordertimes=" + ordertimes + ", count=" + count + ", price=" + price + ", vname=" + vname
					+ "]";
		}
	 

}
