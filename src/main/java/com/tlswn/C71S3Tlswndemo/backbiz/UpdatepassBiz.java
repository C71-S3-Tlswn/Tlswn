package com.tlswn.C71S3Tlswndemo.backbiz;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.bean.AdminExample;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;
import com.tlswn.C71S3Tlswndemo.util.Md5;
@Service
public class UpdatepassBiz {
	@Resource
	AdminMapper am;
	
	public int selectApass(Admin admin){
		AdminExample example=new AdminExample();
		example.createCriteria().andApassEqualTo(Md5.getMD5(admin.getApass()));
		List<Admin> a=am.selectByExample(example);
		if(a.size()!=0){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	public int updateApass(Admin admin,HttpSession sess){
		admin.setApass(Md5.getMD5(admin.getApass()));
		admin.setAaid(((Admin) sess.getAttribute("admin")).getAaid());
		int re=am.updateByPrimaryKeySelective(admin);
		sess.removeAttribute("admin");
		return re;
		
	}
}
