package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.biz.AdminBiz;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;
import com.tlswn.C71S3Tlswndemo.util.Md5;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class AdminAction {
	
	@Resource
	private AdminBiz abiz;
	@Resource
	private AdminMapper am;
	
	@GetMapping("back/adminlogin")
	public String login(){
		return "back/adminlogin";
	}
	
	@ResponseBody
	@PostMapping("back/toadminlogin")
	public Result login(@Valid Admin admin,Errors errors,Model m,HttpSession hs){
		try {
			if(errors.hasErrors()){
				return new Result(2, "表单验证错误",errors.getFieldErrors());
			}
			admin.setApass(Md5.getMD5(admin.getApass()));
			System.out.println(admin.getApass());
			admin=abiz.login(admin);
			m.addAttribute("admin", admin);
			hs.setAttribute("admin", admin);
			return new Result(1, "登录成功!",admin);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}catch (RuntimeException e){
			e.printStackTrace();
			return new Result(0,"业务繁忙，稍后再试");
		}
		
	}
}
