package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SparklineAction {
	
	@GetMapping("back/charts/sparkline")
	public String Sparkline(){
		return "back/charts/sparkline";
	}
	

}
