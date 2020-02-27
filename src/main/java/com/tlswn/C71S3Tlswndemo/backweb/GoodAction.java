package com.tlswn.C71S3Tlswndemo.backweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodAction {

	@GetMapping("back/tables/goodtables")
	public String showGood(){
		
		return "back/tables/goodtables";
	}
}
