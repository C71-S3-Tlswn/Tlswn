package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;

@Controller
public class FoodAction {
	
	private final static int Page_index=9;
	
	@Resource
	private CommodityMapper cm;
	
	
	@GetMapping("food")
	public String index(){
		return "food";
	}
	@GetMapping("food_{id}")
	public String Page(@PathVariable("id") Integer page,String next,Model m){
		PageHelper.startPage(page, Page_index);
		m.addAttribute("clist", cm.selectByExample(null));
		return "food";
	}

}
