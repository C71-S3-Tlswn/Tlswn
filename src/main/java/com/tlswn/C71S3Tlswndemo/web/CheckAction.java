package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tlswn.C71S3Tlswndemo.bean.AddrExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.CartMapper;


@Controller
public class CheckAction {
	
	@Resource
	private CartMapper cm;
	@Resource 
	private AddrMapper am;
	
	@GetMapping("checkout")
	public String Check(){
		return "checkout";
	}
	@ModelAttribute
	public void init(Model m,HttpServletRequest ht){
		
		CartExample ce=new CartExample();
		Criteria c=ce.createCriteria();
		User user= (User) ht.getAttribute("User");
		c.andUidEqualTo(user.getUid());
		m.addAttribute("cart", cm.selectByExample(ce));	
		AddrExample ae=new AddrExample();
		com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cr=ae.createCriteria();
		cr.andUidEqualTo(user.getUid());
		cr.andAstatusEqualTo(1);
		m.addAttribute("addr", am.selectByExample(ae));
		
	}
}
