package com.tlswn.C71S3Tlswndemo.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.biz.UserBiz;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;
import com.tlswn.C71S3Tlswndemo.util.Md5;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class LoginAction {


	@Resource
	private UserBiz ubiz;
	@Resource
	private UserMapper um;
	
	@GetMapping("login")
	public ModelAndView Login(){
		return new ModelAndView("login");
	}
	@ResponseBody
	@PostMapping("dologin")
	public Result login(@Valid User user,Errors errors,Model m,HttpSession sess){
		try {
			if(errors.hasErrors()){
				return new Result(2, "表单验证错误",errors.getFieldErrors());
			}else{
				user.setUpass(Md5.getMD5(user.getUpass()));
				user=ubiz.login(user);
				m.addAttribute("User", user);
				sess.setAttribute("User", user);
				return new Result(1, "登录成功!",user);
			}	
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}catch (RuntimeException e){
			e.printStackTrace();
			return new Result(0,"业务繁忙，稍后再试");
		}
		
	}
}
