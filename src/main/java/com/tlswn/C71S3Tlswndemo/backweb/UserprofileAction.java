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

import com.tlswn.C71S3Tlswndemo.backbiz.UserprofileBiz;
import com.tlswn.C71S3Tlswndemo.bean.Admin;

@Controller
public class UserprofileAction {
	@Resource
	UserprofileBiz ub;

	@GetMapping("profile")
	public String toProfile(HttpSession sess,Model m){
		Admin admin=ub.getProfile(sess);
		m.addAttribute("admin", admin);
		return "back/userprofile";
	}
	
	@ResponseBody
	@PostMapping("save")
	public String save(MultipartFile img,@Value("${user.file.path}") String filePath) {
		String fileName=ub.save(img, filePath);
		return fileName;
	}
	
	@ResponseBody
	@PostMapping("update")
	public int update(Admin admin,HttpSession sess) {
		int result=ub.update(admin, sess);
		return result;
	}
}
