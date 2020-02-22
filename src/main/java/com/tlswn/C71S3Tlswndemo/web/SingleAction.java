package com.tlswn.C71S3Tlswndemo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.Evaluate;
import com.tlswn.C71S3Tlswndemo.bean.EvaluateExample;
import com.tlswn.C71S3Tlswndemo.bean.Stock;
import com.tlswn.C71S3Tlswndemo.bean.StockExample;
import com.tlswn.C71S3Tlswndemo.bean.StockExample.Criterion;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.EvaluateMapper;
import com.tlswn.C71S3Tlswndemo.dao.StockMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class SingleAction {
	
	@Resource
	private CommodityMapper cm;
	@Resource
	private EvaluateMapper em;
	@Resource
	private StockMapper sm;
	
	@GetMapping("single")
	public String Single(){
		return "single";
	}
	@GetMapping("single2")
	public String Single2(){
		return "single2";
	}
	@PostMapping("/selectNum")
	@ResponseBody
	public Result findNum(String color,String specs,Integer cid,Model m){
		StockExample st=new StockExample();
		st.createCriteria().andCidEqualTo(cid).andSpecsEqualTo(specs).andColorEqualTo(color);
		List<Stock> list= sm.selectByExample(st);
		return new Result(1, null,list );
	}
	@GetMapping("single_{id}")
	public String toSingle(@PathVariable("id") Integer id,String specs,Model m){
		EvaluateExample eve=new EvaluateExample();
		eve.createCriteria().andCidEqualTo(id);
		List<Evaluate> evs=em.selectByExample(eve);
		m.addAttribute("evs", evs);
		
	    Commodity comm=	cm.selectByPrimaryKey(id);
	    m.addAttribute("commodity", comm);
	    StockExample se=new StockExample();
		se.createCriteria().andCidEqualTo(id);
		List<Stock> sto= sm.selectByExample(se);
		m.addAttribute("size", sto);
		return "single";
		
	}
}
