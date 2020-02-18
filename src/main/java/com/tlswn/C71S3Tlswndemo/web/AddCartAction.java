package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.CartBiz;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class AddCartAction {

	@Resource
	private CartBiz cbiz; 
	
	@PostMapping("/addcart")
	public Result addcart(Cart cart,
			@SessionAttribute("User") User user,
			Error error,Model m){
		cart.setUid(user.getUid());
		cbiz.add(cart);
		m.addAttribute("cart", cart);
		if(cart.getUid()==null&&cart.getUid().equals("")){
			return new Result(3, "您尚未登录，请登录");
		}else if(cart.getCount()==null&&cart.getCount().equals("")){
			return new Result(2,"添加失败，请选择数量");
		}else if(cart.getCtemp()==null&&cart.getCtemp().equals("")){
			return new Result(0, "您没有选择尺码，请选择尺码");
		}else{
		return new Result(1, "添加成功", cart);
		}
	}
}
