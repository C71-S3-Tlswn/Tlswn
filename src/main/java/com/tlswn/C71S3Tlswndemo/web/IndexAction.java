package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		m.addAttribute("nuts", cm.selectBythree(ce));
		CommodityExample ce2=new CommodityExample();
		Criteria c1=ce2.createCriteria();
		c1.andTidBetween(7, 11);
		m.addAttribute("women", cm.selectBythree(ce2));
		CommodityExample ce3=new CommodityExample();
		Criteria c2=ce3.createCriteria();
		c2.andTidBetween(12, 15);
		m.addAttribute("ce3", cm.selectBythree(ce3));
		CommodityExample ce4=new CommodityExample();
		Criteria c3=ce4.createCriteria();
		c3.andTidBetween(22, 27);
		m.addAttribute("ce4", cm.selectBythree(ce4));
		
		
		m.addAttribute("ce5",cm.selectBySix(null));
		
		m.addAttribute("ce6",cm.selectBythree(null));
		System.out.println(cm.selectBythree(null));
		
		return "index";
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
