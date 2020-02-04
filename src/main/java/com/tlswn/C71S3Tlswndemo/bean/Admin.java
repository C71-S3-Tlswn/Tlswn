package com.tlswn.C71S3Tlswndemo.bean;

public class Admin {
    private Integer aaid;

    private String accounnt;

    private String aname;

    private String email;

    private String tel;

    private Integer status;

    private String photo;

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
}