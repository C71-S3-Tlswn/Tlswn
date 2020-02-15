package com.tlswn.C71S3Tlswndemo.bean;

public class Variety {
    private Integer vid;

    private String vname;

    private String temp;

    private String temp2;

    private Integer temp3;

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
        this.vname = vname == null ? null : vname.trim();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    public Integer getTemp3() {
        return temp3;
    }

    public void setTemp3(Integer temp3) {
        this.temp3 = temp3;
    }
}