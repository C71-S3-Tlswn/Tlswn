package com.tlswn.C71S3Tlswndemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tlswn.C71S3Tlswndemo.bean.User;


@Controller
public class CheckAction {
	
	@GetMapping("checkout")
	public String Check(){
		return "checkout";
	}
	/*@ModelAttribute
	public void init(Model m,@SessionAttribute("User") User user){
		
	}*/
	
}
