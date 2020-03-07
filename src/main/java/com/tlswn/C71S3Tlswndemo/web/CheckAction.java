package com.tlswn.C71S3Tlswndemo.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.AddrExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.CartMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;


@Controller
public class CheckAction {
	
	@Resource
	private CartMapper cm;
	@Resource 
	private AddrMapper am;
	@Resource
	private OrderMapper om;
	@Resource
	private VarietyMapper vm;
	
	
	@GetMapping("checkout")
	public String Check(){
		return "checkout";
	}
	//取消商品
	@ResponseBody
	@PostMapping("dodelet")
	public Result delet(Integer cid){
		CartExample ce=new CartExample();
		Criteria c=ce.createCriteria();
		c.andCidEqualTo(cid);
		 int i=cm.deleteByExample(ce);
		if(i>0){
			return new Result(1, "取消成功!!!");
		}else{
			return new Result(0, "取消失败，稍后再试！");
		}
	}
	//显示购物车
	@ResponseBody
	@GetMapping("docart")
	public Result Cart(Model m,HttpServletRequest ht){
		User user= (User) ht.getSession().getAttribute("User");
		if(null==user){
			return new Result(2,"请先登录");
		}else{
			CartExample ce=new CartExample();
			Criteria c=ce.createCriteria();
			c.andUidEqualTo(user.getUid());
			List<Cart> list=cm.selectByExample(ce);		
			return new Result(1,"",list);			
		}
	}
	@ModelAttribute
	public void init(Model m,HttpServletRequest ht){	
		User user= (User) ht.getSession().getAttribute("User");	
		if(null==user){
			return ;
		}else{
		AddrExample ae=new AddrExample();
		com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cr=ae.createCriteria();
		cr.andUidEqualTo(user.getUid());
		cr.andAstatusEqualTo(1);
		m.addAttribute("addr", am.selectByExample(ae));	
		}
	}
	

	
		List<String> list=new ArrayList<>();
		//生成订单
		@PostMapping("doorder")
		@ResponseBody
		public Result Order(com.tlswn.C71S3Tlswndemo.bean.Order ord,HttpServletRequest ht,String temps){
			User user= (User) ht.getSession().getAttribute("User");
			ord.setUid(user.getUid()); 
			 ord.setOrdertime(new Date());// new Date()为获取当前系统时间
			 ord.setStatus(0);	
			 ord.setTemp("1");
			// String temps=String.valueOf(System.currentTimeMillis()+new Random().nextInt(1000));
			 ord.setTemp2(temps);
			list.add(temps);
			int i=om.insert(ord);
			CartExample ce=new CartExample();
			Criteria cr=ce.createCriteria();
			cr.andUidEqualTo(user.getUid());
			cr.andCidEqualTo(ord.getCid());
			int a=cm.deleteByExample(ce);
				System.out.println(list);
				
		
			if(i>0&&a>0){
				return new Result(1,temps);
			}else{
				return new Result(0,"");
			}
		}		
		

	@ModelAttribute
	public void init(Model m){
		m.addAttribute("variety",vm.selectByExample(null) );
	}
}
