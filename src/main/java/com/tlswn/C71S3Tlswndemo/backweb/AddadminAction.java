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
import com.tlswn.C71S3Tlswndemo.backbiz.UserprofileBiz;
import com.tlswn.C71S3Tlswndemo.bean.Admin;

@Controller
public class AddadminAction {
	@Resource
	AddadminBiz ab;

	@GetMapping("add")
	public String toProfile(HttpSession sess,Model m){
		return "back/addadmin";
	}
	
	
	@ResponseBody
	@PostMapping("insert")
	public int insert(Admin admin) {
		int result=ab.insert(admin);
		return result;
	}
}
