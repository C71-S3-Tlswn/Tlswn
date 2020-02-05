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
import com.tlswn.C71S3Tlswndemo.vo.Result;

@RestController
@SessionAttributes("loginUser")
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	@PostMapping("login")
	public Result login(@Valid User user,Errors errors,Model m){
		try {
			if(errors.hasErrors()){
				return new Result(2, "表单验证错误",errors.getFieldErrors());
			}
			user=ubiz.login(user);
			m.addAttribute("loginUser", user);
			return new Result(1, "登录成功!",user);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}catch (RuntimeException e){
			e.printStackTrace();
			return new Result(0,"业务繁忙，稍后再试");
		}
		
	}
	@PostMapping("SingUp")
	public Result SingUp(@Valid User user,Errors errors) throws BizException{
		try {
			if(errors.hasErrors()){
				return new Result(2, "表单验证错误",errors.getFieldErrors());
			}
			int i=um.insert(user);
			if(i>0){
				return new Result(1, "注册成功!");
			}else{
				return new Result(0,"业务繁忙，稍后再试");
			}
		} catch (RuntimeException e){
			e.printStackTrace();
			return new Result(0,"业务繁忙，稍后再试");
		}
	}
}
