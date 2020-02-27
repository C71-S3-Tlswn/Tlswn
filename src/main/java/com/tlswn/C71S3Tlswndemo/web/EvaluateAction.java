package com.tlswn.C71S3Tlswndemo.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.Evaluate;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.biz.BizException;
import com.tlswn.C71S3Tlswndemo.biz.EvaluateBiz;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
@Controller
public class EvaluateAction {
	
	@Resource
	private CommodityMapper cm;
	@Resource
	private EvaluateBiz eb;
	
	@GetMapping("evaluate")
	public String comment(){
		return "evaluate";
	}
	
	@GetMapping("evaluate_{id}")
	public String toSingle(@PathVariable("id") Integer id,Model m){
	    Commodity comm=	cm.selectByPrimaryKey(id);
	    m.addAttribute("commodity", comm);
		return "evaluate";
		
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
	
	@ResponseBody
	@PostMapping("publish")
	public int publish(Evaluate ev,HttpSession sess){
		int re=0;
		try {
			re = eb.publish(ev, sess);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return re;
		
	}
}
