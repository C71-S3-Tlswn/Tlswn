package com.tlswn.C71S3Tlswndemo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

@Controller
public class lookUpAction {
	
	@Resource
	private VarietyMapper vm;
	@Resource
	private TypeMapper tm;

	
	@Resource
	private CommodityMapper cm;
	
	@GetMapping("lookup")
	public String LookUp(Model m){
		return "lookup";
	}
	List<Commodity> plist=null;
	Integer page=0;
	//查询商品
	@PostMapping("dofind")
	public String  Find(String newpro,String hot,String search,Integer bprice,Integer eprice,Model m){
		CommodityExample ce=new CommodityExample();
		Criteria c=ce.createCriteria();
		if(newpro!=null){
			newpro=getPastDate(30);
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			 Date date =null;
			try {
				date = format.parse(newpro);
			} catch (ParseException e) {
				e.printStackTrace();
			}          
			c.andCBtimeGreaterThanOrEqualTo(date);
		};
		if(hot!=null){
			c.andHotEqualTo(1);
		};
		if(search!=null&&search!=""){
			String cname="%"+search+"%";
			c.andCnameLike(cname);
		};
		if(bprice!=0&&eprice!=0){
			c.andCpriceBetween(Double.valueOf(bprice), Double.valueOf(eprice));
		};
		if(page==null|| page<=1){
			page=1;
		}
		plist=cm.selectByExample(ce);
		m.addAttribute("lookUp",plist);
		System.out.println(plist);
		return "lookup::wrapper";	
	}

	public static String getPastDate(int past) {  
	       Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	       String result = format.format(today);  
	       return result;  
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
