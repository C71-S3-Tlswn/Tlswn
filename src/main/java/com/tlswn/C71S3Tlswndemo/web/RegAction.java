package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.biz.UserBiz;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;
import com.tlswn.C71S3Tlswndemo.util.Md5;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class RegAction {
	

	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	@GetMapping("reg")
	public String Reg(){
		return "reg";
	}
	@ResponseBody
	@PostMapping("SingUp")
	public Result SingUp(@Valid User user,Errors errors) throws BizException{
		try {
			if(errors.hasErrors()){
				return new Result(2, "表单验证错误",errors.getFieldErrors());
			}
			user.setUpass(Md5.getMD5(user.getUpass()));
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
