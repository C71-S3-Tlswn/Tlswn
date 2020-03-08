package com.tlswn.C71S3Tlswndemo.backweb;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tlswn.C71S3Tlswndemo.backbiz.UserprofileBiz;
import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;


@Controller
public class BackIndexAction {
	
	@Resource
	private UserMapper um;
	
	@Resource
	private CommodityMapper cm;
	
	@Resource
	private OrderMapper om;
	
	
	@GetMapping("back/index")
	public String BackIndex(HttpSession sess,Model m){
		return "back/index";
	}
	
	@ModelAttribute
	public void init(Model m){
		
		List<User> list=um.selectByExample(null);
		m.addAttribute("uSize", list.size());
		List<Commodity> clist=cm.selectByExample(null);
		m.addAttribute("cSize", clist.size());
		
		List<Order> olist=om.selectByExample(null);
		m.addAttribute("oSize", olist.size());
		Double total=0.0;
		for(int i=0;i<olist.size();i++){
			total+=olist.get(i).getOprice();
		}
		m.addAttribute("totalprice", total);
		
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -1);
		date = calendar.getTime();
		Date date2=new Date();
		OrderExample e=new OrderExample();
		e.createCriteria().andOrdertimeBetween(date,date2);
		SimpleDateFormat format= new SimpleDateFormat("MM-dd");
		String dateString = format.format(date);
		String d=format.format(date2);
		m.addAttribute("lastday",dateString);
		m.addAttribute("today",d);
		List<Order> Nowlist=om.selectByExample(e);
		Double per=0.0;
		for(int i=0;i<Nowlist.size();i++){
			per+=Nowlist.get(i).getOprice();
			Nowlist.get(i).getTemp3();
		}
		m.addAttribute("per",per);
		
		m.addAttribute("chot", cm.selectByHot());
		
		
		
		
		
	}

}
