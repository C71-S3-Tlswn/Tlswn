package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAction {
	
	@GetMapping("back/adminindex")
	public String BackIndex(){
		return "back/adminindex";
	}
	@GetMapping("back/index")
	public String index(){
		return "back/index";
	}

}
