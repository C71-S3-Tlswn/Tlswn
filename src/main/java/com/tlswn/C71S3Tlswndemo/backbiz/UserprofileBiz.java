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
public class UserprofileBiz {
	@Resource
	AdminMapper am;
	
	public Admin getProfile(HttpSession sess){
		Admin admin= (Admin) sess.getAttribute("admin");
		admin=am.selectByPrimaryKey(admin.getAaid());
		return admin;
		
	}
	
	public String save(MultipartFile img, String filePath){
		String fileName=null;
		try {
			// 保存图片
			/*File file = new File(filePath + img.getOriginalFilename());*/
			File file=new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			fileName=img.getOriginalFilename();
			file=new File(filePath + fileName);
			img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public int update(Admin admin,HttpSession sess){
		int aid=((Admin) sess.getAttribute("admin")).getAaid();
		admin.setAaid(aid);
		int re=am.updateByPrimaryKeySelective(admin);
		
		sess.removeAttribute("admin");
		sess.setAttribute("admin", am.selectByPrimaryKey(aid));
		return re;
	}
}
