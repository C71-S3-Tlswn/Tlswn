package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/addcart")
	public Result addcart(Cart cart,
			@SessionAttribute("User") User user,
			Error error,Model m){
		CartExample ce=new CartExample();
		ce.createCriteria().andCidEqualTo(cart.getCid()).andCtempEqualTo(cart.getCtemp()).andUidEqualTo(user.getUid());
		List<Cart> old= cm.selectByExample(ce);
		if(old==null || old.isEmpty()){
			cart.setUid(user.getUid());
			
			m.addAttribute("cart", cart);
			if(cart.getUid()==null&&cart.getUid().equals("")){
				return new Result(3, "您尚未登录，请登录");
			}else if(cart.getCount()==null&&cart.getCount().equals("")){
				return new Result(2,"添加失败，请选择数量");
			}else if(cart.getCtemp()==null&&cart.getCtemp().equals("")){
				return new Result(0, "您没有选择尺码，请选择尺码");
			}else{
				cbiz.add(cart);
			return new Result(1, "添加成功", cart);
			}
			
		}else{
			CartExample ce2=new CartExample();
			ce2.createCriteria().andUidEqualTo(user.getUid()).
			andCtempEqualTo(cart.getCtemp()).andCidEqualTo(cart.getCid());
			/*cm.updateByExampleNum(count, ce2);*/
			return new Result(1, "添加成功");
		}
			
	}

}
