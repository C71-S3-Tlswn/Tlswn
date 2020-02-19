package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.Evaluate;
import com.tlswn.C71S3Tlswndemo.bean.EvaluateExample;
import com.tlswn.C71S3Tlswndemo.bean.Stock;
import com.tlswn.C71S3Tlswndemo.bean.StockExample;
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
}
