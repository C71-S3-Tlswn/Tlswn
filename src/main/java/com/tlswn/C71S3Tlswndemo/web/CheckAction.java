package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.AddrExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import com.tlswn.C71S3Tlswndemo.bean.CartExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.CartMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;


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
	/*@ModelAttribute
	public void init(Model m,HttpServletRequest ht){	
		User user= (User) ht.getSession().getAttribute("User");	
		AddrExample ae=new AddrExample();
		CartExample ce=new CartExample();
		Criteria c=ce.createCriteria();
		c.andUidEqualTo(user.getUid());
		List<Cart> list=cm.selectByExample(ce);
		m.addAttribute("cart", list);
		com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cr=ae.createCriteria();
		cr.andUidEqualTo(user.getUid());
		cr.andAstatusEqualTo(1);
		m.addAttribute("addr", am.selectByExample(ae));	
	}*/
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
			m.addAttribute("count", cm.countByExample(ce));
			AddrExample ae=new AddrExample();
			com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cr=ae.createCriteria();
			cr.andUidEqualTo(user.getUid());
			cr.andAstatusEqualTo(1);
			m.addAttribute("addr", am.selectByExample(ae));	
			return new Result(1,"",list);	
		}
	}
	
	
}
