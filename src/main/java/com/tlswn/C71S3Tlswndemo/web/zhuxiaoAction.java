package com.tlswn.C71S3Tlswndemo.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class zhuxiaoAction {
@GetMapping("xiaochu")
public String xiaochu(HttpServletRequest request){
	Enumeration em=request.getSession().getAttributeNames();
	while(em.hasMoreElements()){
		request.getSession().removeAttribute(em.nextElement().toString());
	}
	System.out.println("hh");
	return "login";
}
}
