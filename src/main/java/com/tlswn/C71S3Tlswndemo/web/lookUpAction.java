package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;

@Controller
public class lookUpAction {
	
	@Resource
	private CommodityMapper cm;
	
	@GetMapping("lookup")
	public String LookUp(Model m){
		return "lookup";
	}
	
	@PostMapping("dofind")
	public String  Find(Model m,String search){
		System.out.println(search);
		CommodityExample ce=new CommodityExample();
		Criteria c=ce.createCriteria();
		String cname="%"+search+"%";
		c.andCnameLike(cname);
		m.addAttribute("lookUp",cm.selectByExample(ce));
		return "lookup";
	}
}
