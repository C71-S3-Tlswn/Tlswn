package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackTalkAction {
	
	
	@GetMapping("back/talk")
	public String BackTalk(){
		return "back/talk";
	}
}
