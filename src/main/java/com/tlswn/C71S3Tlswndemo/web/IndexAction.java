package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.el.VariableMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

@Controller
public class IndexAction {
	@Resource
	private CommodityMapper cm;
	@Resource
	private VarietyMapper vm;
	@Resource
	private TypeMapper tm;
	
	@GetMapping({"/","index","index.do"})
	public String Index(Model m){
		m.addAttribute("nuts", cm.selectByExample(null));
		return "index";
	}

}
