package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tlswn.C71S3Tlswndemo.bean.Addr;

import com.tlswn.C71S3Tlswndemo.bean.UserExample;
import com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;

@Controller
public class IndexAction {
	@Resource
	private UserMapper us;
	@Resource
	private AddrMapper ad;
	@GetMapping({"/","index","index.do"})
	public String Index(){
		return "index";
	}
	@GetMapping({"dizhi","dizhi.do"})
	public String dizhi(){
		return "dizi";
	}
	@PostMapping("bh.do")
	public String dizi( Addr addr,String uname){
	    
		UserExample ue=new UserExample();
		//构建条件
		Criteria c=ue.createCriteria();
		c.andUnameEqualTo(uname);
	   Integer cc= us.selectByExample(ue).get(0).getUid();
	   addr.setUid(cc);
	  int v= ad.insert(addr);
		System.out.println("........"+v);
		return "index";
	}
}
