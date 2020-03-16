package com.tlswn.C71S3Tlswndemo.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Favorite;
import com.tlswn.C71S3Tlswndemo.bean.FavoriteExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.FavoriteMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.Addr;
import com.tlswn.C71S3Tlswndemo.bean.AddrExample;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
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
	@Resource
	private AddrMapper am;
	@Resource
	private FavoriteMapper fa;
	@Resource
	private UserMapper ua;
	
	
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
	@ResponseBody
	@GetMapping("panduan")
	public Result panduan(HttpServletRequest ht){
		User user= (User) ht.getSession().getAttribute("User");
	    User li=new User();
	    User li2=new User();
		UserExample ue=new UserExample();
		li=ua.selectByPrimaryKey(user.getUid());
		System.out.println(li.getTemp3());
		int c=li.getTemp3();
		 li2.setTemp3(0);
		 com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria cb=ue.createCriteria();
		 cb.andUidEqualTo(user.getUid());
		int x=ua.updateByExampleSelective(li2, ue);
		if(c==1&&x==1){
			return new Result(1,"");
		}else{
			return new Result(0,"");
		}		
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
	public void init(Model m,HttpServletRequest ht){
		m.addAttribute("variety",vm.selectByExample(null) );
		
		TypeExample te=new TypeExample();
		te.createCriteria().andVidEqualTo(1);
		m.addAttribute("type", tm.selectByExample(te));
		
		TypeExample t=new TypeExample();
		t.createCriteria().andVidEqualTo(5);
		m.addAttribute("types", tm.selectByExample(t));
		User user= (User) ht.getSession().getAttribute("User");
		AddrExample ae=new AddrExample();
		ae.createCriteria().andUidEqualTo(user.getUid());
		m.addAttribute("Uaddr",am.selectByExample(ae));
		
		FavoriteExample fac=new FavoriteExample();
		CommodityExample co=new CommodityExample();
		List<Favorite> list=new ArrayList<Favorite>();
		List<Commodity> li=new ArrayList<Commodity>();
		
		com.tlswn.C71S3Tlswndemo.bean.FavoriteExample.Criteria c=fac.createCriteria();
		c.andUidEqualTo(user.getUid());
		list=fa.selectByExample(fac);
		for(int i=0;i<list.size();i++){
			int cid=0;
			cid=list.get(i).getTemp3();
			li.add(i, cm.selectByPrimaryKey(cid));//根据 id查商品
			li.get(i).setCid(cid);
		}
		m.addAttribute("li", li);
	}
	
	
}
