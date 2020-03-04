package com.tlswn.C71S3Tlswndemo.backbiz;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;
@Service
public class AddadminBiz {
	@Resource
	AdminMapper am;
	
	public int insert(Admin admin){
		
		admin.setAccounnt(admin.getAname());
		admin.setApass("d9f6e636e369552839e7bb8057aeb8da");
		admin.setStatus(1);
		int re=am.insertSelective(admin);
		return re;
	}
}
