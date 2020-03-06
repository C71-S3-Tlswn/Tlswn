package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;

@Controller
public class SaleAction {

	@Resource
	private CommodityMapper cm;
	
	@GetMapping("sale")
	public String sale(Model m){
		CommodityExample ce=new CommodityExample();
		ce.createCriteria().andTemp2LessThan(100);
		List<Commodity> list=cm.selectByExample(ce);
		m.addAttribute("sale", list);
		return "sale";
	}
}
