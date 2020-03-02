package com.tlswn.C71S3Tlswndemo.backbiz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.bean.AdminExample;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;

@Service
public class AdminBiz {
	
	@Resource
	private AdminMapper am;
	
	public Admin login(Admin admin) throws BizException{
		AdminExample  example=new AdminExample();
		example.createCriteria().andTelEqualTo(admin.getTel())
								.andApassEqualTo(admin.getApass());
		List<Admin> list=am.selectByExample(example);
		if(list.size()==0){
			throw new BizException("用户名或密码错误");
		}else{
			return list.get(0);
		}
	}
}
