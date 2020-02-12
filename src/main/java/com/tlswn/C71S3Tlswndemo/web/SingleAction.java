package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;

@Controller
public class SingleAction {
	
	@Resource
	private CommodityMapper cm;
	
	@GetMapping("single")
	public String Single(){
		return "single";
	}
	@GetMapping("single2")
	public String Single2(){
		return "single2";
	}
	@GetMapping("single_{id}")
	public String toSingle(@PathVariable("id") Integer id,Model m){
		
	    Commodity comm=	cm.selectByPrimaryKey(id);
	    m.addAttribute("commodity", comm);
		return "single";
	}
}
