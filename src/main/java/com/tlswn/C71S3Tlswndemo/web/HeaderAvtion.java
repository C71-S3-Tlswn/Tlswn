package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

@Controller
public class HeaderAvtion {
	
	@Resource
	private VarietyMapper vm;
	
	@ModelAttribute
	public void init(Model m){
		m.addAttribute("variety",vm.selectByExample(null) );
	}
}
