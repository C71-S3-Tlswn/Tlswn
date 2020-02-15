package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.biz.UserBiz;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;
import com.tlswn.C71S3Tlswndemo.util.Md5;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@RestController
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	
	
}
