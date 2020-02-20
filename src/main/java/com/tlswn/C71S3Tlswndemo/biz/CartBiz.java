package com.tlswn.C71S3Tlswndemo.biz;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import com.tlswn.C71S3Tlswndemo.dao.CartMapper;

@Service
public class CartBiz {

	@Resource
	private CartMapper cm;
	
	public void add(Cart cart){
		cm.insert(cart);
	}
	
	public void update(Cart cart){
		
	}
}
