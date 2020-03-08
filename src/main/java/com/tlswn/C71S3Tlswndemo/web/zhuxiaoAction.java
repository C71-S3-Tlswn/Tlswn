package com.tlswn.C71S3Tlswndemo.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.User;

@Controller
public class zhuxiaoAction {
	
	
	@PostMapping("outlogin")
	@ResponseBody
	public Integer outlogin(HttpServletRequest request){
		
		HttpSession session = request.getSession();//获取当前session
		if(session!=null){
			User user = (User)session.getAttribute("User");//从当前session中获取用户信息
			session.invalidate();//关闭session
		}
		return 1;
	}
}
