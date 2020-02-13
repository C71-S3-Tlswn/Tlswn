package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.el.VariableMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
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
		CommodityExample ce=new CommodityExample();
		Criteria c=ce.createCriteria();
		c.andTidBetween(1, 5);
		m.addAttribute("nuts", cm.selectByExample(ce));
		m.addAttribute("variety",vm.selectByExample(null) );
		TypeExample te=new TypeExample();
		com.tlswn.C71S3Tlswndemo.bean.TypeExample.Criteria cr=te.createCriteria();
		cr.andVidEqualTo(1);
		m.addAttribute("type", tm.selectByExample(te));
		return "index";
	}

}
