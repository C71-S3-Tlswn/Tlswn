package com.tlswn.C71S3Tlswndemo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tlswn.C71S3Tlswndemo.backbiz.UserprofileBiz;
import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
	/*@Resource
	UserprofileBiz ub;*/
	
	@Override
    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	Admin admin=(Admin) request.getSession().getAttribute("admin");
        if (admin== null){
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
        	/*response.getWriter().write("抱歉，您还未登录");*/
        	response.sendRedirect("/back/login");
            return false;
        }else {
        	/*Admin adminModel=ub.getProfile(request.getSession());
        	m.addAttribute("admin",adminModel);*/
        	 //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
            return true;   
        }
		
    }
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
	
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}