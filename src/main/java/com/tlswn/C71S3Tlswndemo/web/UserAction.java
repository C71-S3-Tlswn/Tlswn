package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;


import com.tlswn.C71S3Tlswndemo.biz.UserBiz;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;


@RestController
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	
	
}
