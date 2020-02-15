package com.tlswn.C71S3Tlswndemo.bean;

public class Admin {
    private Integer aaid;

    private String accounnt;

    private String apass;

    private String aname;

    private String email;

    private String tel;

    private Integer status;

    private String photo;

    private String temp;

    private String temp2;

    private Integer temp3;

    public Integer getAaid() {
        return aaid;
    }

    public void setAaid(Integer aaid) {
        this.aaid = aaid;
    }

    public String getAccounnt() {
        return accounnt;
    }

    public void setAccounnt(String accounnt) {
        this.accounnt = accounnt == null ? null : accounnt.trim();
    }

    public String getApass() {
        return apass;
    }

    public void setApass(String apass) {
        this.apass = apass == null ? null : apass.trim();
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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