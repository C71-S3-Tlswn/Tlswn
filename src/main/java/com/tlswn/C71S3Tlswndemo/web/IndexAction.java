package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tlswn.C71S3Tlswndemo.bean.Addr;

import com.tlswn.C71S3Tlswndemo.bean.UserExample;

import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;


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
	@GetMapping({"dizhi","dizhi.do"})
	public String dizhi(){
		return "dizi";
	}
	/*@PostMapping("bh.do")
	public String dizi( Addr addr,String uname){
	    
		UserExample ue=new UserExample();
		//构建条件e
		Criteria c=ue.createCriteria();
		c.andUnameEqualTo(uname);
	   Integer cc= us.selectByExample(ue).get(0).getUid();
	   addr.setUid(cc);
	  int v= ad.insert(addr);
		System.out.println("........"+v);
		return "index";
	}*/
}
