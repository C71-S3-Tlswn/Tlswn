package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackIndexAction {
	
	@GetMapping("back/index")
	public String BackIndex(){
		
		return "back/index";
	}

}
