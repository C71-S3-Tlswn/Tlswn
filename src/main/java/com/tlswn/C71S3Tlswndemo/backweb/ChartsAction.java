package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartsAction {
	
	@GetMapping("back/charts/charts")
	public String Charts(){
		
		return "back/charts/charts";
	}

}
