package com.tlswn.C71S3Tlswndemo.backweb;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.backbiz.AddadminBiz;
import com.tlswn.C71S3Tlswndemo.backbiz.UpdatepassBiz;
import com.tlswn.C71S3Tlswndemo.backbiz.UserprofileBiz;
import com.tlswn.C71S3Tlswndemo.bean.Admin;

@Controller
public class UpdatepassAction {
	@Resource
	UpdatepassBiz ub;

	@GetMapping("back/update")
	public String toProfile(HttpSession sess,Model m){
		return "back/updatepwd";
	}
	
	
	@ResponseBody
	@PostMapping("back/selectpwd")
	public int select(Admin admin) {
		int result=ub.selectApass(admin);
		return result;
	}
	
	@ResponseBody
	@PostMapping("back/updatepwd")
	public int update(Admin admin, HttpSession sess) {
		int result=ub.updateApass(admin, sess);
		return result;
	}
}
