package com.tlswn.C71S3Tlswndemo.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.bean.UserExample;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;

@Service
public class UserBiz {
	
	@Resource
	private UserMapper um;
	
	public User login(User user) throws BizException{
		UserExample  example=new UserExample();
		example.createCriteria().andUtelEqualTo(user.getUtel())
								.andUpassEqualTo(user.getUpass());
		List<User> list=um.selectByExample(example);
		if(list.size()==0){
			throw new BizException("用户名或密码错误");
		}else{
			return list.get(0);
		}
	}
}
