package com.tlswn.C71S3Tlswndemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodAction {
	
	@GetMapping("food")
	public String index(){
		return "food";
	}

}
