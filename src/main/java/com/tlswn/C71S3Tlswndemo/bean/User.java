package com.tlswn.C71S3Tlswndemo.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class User {
    private Integer uid;

    private String uname;
    @NotEmpty(message="请输入账号！")
    @Length(min=6,max = 12,message="账号长度必须位于6到12之间")
    private String uaccount;
    @NotEmpty(message="请填写密码！")
    private String upass;
    @Pattern(regexp="/^[1][3,4,5,7,8][0-9]{9}$/",message="请输入正确的手机号码")
    @NotEmpty(message="请填写手机号码！")
    private String utel;

    private String uemail;

    private Integer usex;

    private String uphoto;

    private String ucard;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount == null ? null : uaccount.trim();
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass == null ? null : upass.trim();
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel == null ? null : utel.trim();
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto == null ? null : uphoto.trim();
    }

    public String getUcard() {
        return ucard;
    }

    public void setUcard(String ucard) {
        this.ucard = ucard == null ? null : ucard.trim();
    }
}