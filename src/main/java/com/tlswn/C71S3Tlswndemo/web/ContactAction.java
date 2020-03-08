package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

@Controller
public class ContactAction {
	@Resource
	private VarietyMapper vm;
	@Resource
	private TypeMapper tm;

	@GetMapping("contact")
	public String Contact(){
		return "contact";
	}
	@ModelAttribute
	public void init(Model m){
		m.addAttribute("variety",vm.selectByExample(null) );
		
		TypeExample te=new TypeExample();
		te.createCriteria().andVidEqualTo(1);
		m.addAttribute("type", tm.selectByExample(te));
		
		TypeExample t=new TypeExample();
		t.createCriteria().andVidEqualTo(5);
		m.addAttribute("types", tm.selectByExample(t));
	}
}
