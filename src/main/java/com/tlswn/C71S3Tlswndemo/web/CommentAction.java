package com.tlswn.C71S3Tlswndemo.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
@Controller
public class CommentAction {
	
	@Resource
	private CommodityMapper cm;
	
	@GetMapping("comment")
	public String comment(){
		return "comment";
	}
	
	@GetMapping("comment_{id}")
	public String toSingle(@PathVariable("id") Integer id,Model m){
	    Commodity comm=	cm.selectByPrimaryKey(id);
	    m.addAttribute("commodity", comm);
		return "comment";
		
	}
	@ResponseBody
	@PostMapping("upload")
	public String update(MultipartFile img,@Value("${user.file.path}") String filePath) {
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
}
