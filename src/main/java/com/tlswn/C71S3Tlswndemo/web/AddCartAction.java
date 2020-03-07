package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.CartBiz;
import com.tlswn.C71S3Tlswndemo.dao.CartMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class AddCartAction {

	@Resource
	private CartBiz cbiz;
	@Resource
	private CartMapper cm;

	@PostMapping("addcart")
	@ResponseBody
	public Result addcart(Cart cart,
			@SessionAttribute("User") User user,
			Error error,Model m){
		CartExample ce=new CartExample();
		if(user.getUid()==null||user.getUid().equals("")){
			return new Result(0, "您尚未登录，请登录");
		}
		System.out.println(user.getUid());
		System.out.println(cart.getCid());
		System.out.println(cart.getCtemp());
		System.out.println(cart.getCtemp2());
		ce.createCriteria().andCidEqualTo(cart.getCid()).andCtempEqualTo(cart.getCtemp()).andCtemp2EqualTo(cart.getCtemp2()).andUidEqualTo(user.getUid());
		List<Cart> old= cm.selectByExample(ce);
		System.out.println(old);
		if(old==null || old.isEmpty()){
			
			 if(cart.getCount()==null||cart.getCount().equals("")){
				return new Result(2,"添加失败，请选择数量");
			}else if((cart.getCtemp()==null&&cart.getCtemp().equals(""))){
				return new Result(0, "您没有选择尺码，请选择尺码");
			}else{
				cart.setUid(user.getUid());
				cm.insertSelective(cart);
			return new Result(1, "添加成功", cart);
			}
			
		}else{
			CartExample ce2=new CartExample();
			ce2.createCriteria().andUidEqualTo(user.getUid()).
			andCtempEqualTo(cart.getCtemp()).andCtemp2EqualTo(cart.getCtemp2()).andCidEqualTo(cart.getCid());
		    cm.updateByExampleSelective(cart, ce2);
			return new Result(1, "添加成功");
		}
			
	}

}
