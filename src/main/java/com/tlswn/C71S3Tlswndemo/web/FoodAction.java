package com.tlswn.C71S3Tlswndemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Type;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;

@Controller
public class FoodAction {
	
	private final static int Page_index=9;
	
	@Resource
	private CommodityMapper cm;
	
	@Resource
	private TypeMapper tm;
	
	/*
	@GetMapping("food")
	public String index(){
		return "food";
	}*/
	//分页查询
	@GetMapping("food")
	public String Page(/*@PathVariable("id")*/ Integer page,Model m){
		TypeExample te=new TypeExample();
		Criteria c=te.createCriteria();
		c.andVidEqualTo(1);
		List<Type> list=tm.selectByExample(te);
		List<Integer> tlist=new ArrayList<Integer>(); 
		for(int i=0;i<list.size();i++){
			 int  a=list.get(i).getTid();
			 tlist.add(a);	 
		}
		CommodityExample ce=new CommodityExample();
		com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria ct=ce.createCriteria();
		ct.andTidIn(tlist);	
		if(page==null|| page<=1){
			page=1;
		}
		PageHelper.startPage(page, Page_index);
		if(page-1==1){
			m.addAttribute("page", page);
		}else{
			m.addAttribute("page", page+1);
		}
		
		m.addAttribute("clist", cm.selectByExample(ce));
		return "food";
	}

}
