package com.tlswn.C71S3Tlswndemo.backweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.Orderitem;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderitemMapper;

@Controller
public class ChartsAction {
	
	@Resource
	private OrderitemMapper om;
	
	@GetMapping("back/charts/charts")
	public String Charts(){
		
		return "back/charts/charts";
	}
	
	
	@PostMapping("showorder")
	@ResponseBody
	public Map<String, Object> init(Model m){
		
		//查询数据
		List<Orderitem> list=om.selectByExample(null);
		
		Map<String,Object> ret=new HashMap<>();
		
		Map<String,Object> xAxis=new HashMap<>();
		Map<String,Object> yAxis=new HashMap<>();
		List<Map<String,Object>> series=new ArrayList<>();
		
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		ret.put("series",series);
		List<String> data1=new ArrayList<>();
		List<String> data2=new ArrayList<>();
		for(Orderitem row:list){
			data1.add((""+row.getCid()));
			data2.add((""+row.getCount()));
		}
		xAxis.put("type", "category");
		xAxis.put("data", data1);	
		yAxis.put("type", "value");
		
		Map<String,Object> seriesInner=new HashMap<>();
		seriesInner.put("type", "line");
		seriesInner.put("data", data2);
		series.add(seriesInner);
		System.out.println(ret);
		return ret;
	}

}
