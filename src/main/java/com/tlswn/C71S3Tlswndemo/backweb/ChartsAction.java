package com.tlswn.C71S3Tlswndemo.backweb;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria;
import com.tlswn.C71S3Tlswndemo.bean.Orderitem;
import com.tlswn.C71S3Tlswndemo.bean.Variety;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderitemMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.NearWeekVo;
import com.tlswn.C71S3Tlswndemo.vo.StatisticsVo;

@Controller
public class ChartsAction {
	
	@Resource
	private OrderitemMapper om;
	@Resource 
	private VarietyMapper vm;
	
	@Resource
	private OrderMapper orm;
	
	@GetMapping("back/charts")
	public String Charts(){
		
		return "back/charts";
	}
	
	
	
	@ResponseBody
	@GetMapping("back/showorder")
	public String init(){
		
		//查询数据
		List<StatisticsVo> list=om.selectStatistics();
		List<Variety> vlist=vm.selectByExample(null);
		
		Map<String,Object> ret=new HashMap<>();
		
		Map<String,Object> xAxis=new HashMap<>();
		Map<String,Object> yAxis=new HashMap<>();
		List<Map<String,Object>> series=new ArrayList<>();
		
		Map<String,Object> tooltip=new HashMap<>();
		
		Map<String,Object> axisPointerInner=new HashMap<>();
		
		ret.put("tooltip",tooltip);
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		ret.put("series",series);
		
		tooltip.put( "trigger", "axis");
		
		axisPointerInner.put( "type", "shadow");
		tooltip.put( "axisPointer", axisPointerInner);
		
		List<String> data1=new ArrayList<>();
		List<String> data2=new ArrayList<>();
			
		//x轴  种类名称	
		for(StatisticsVo v:list){		
			data1.add((""+v.getVname()));
		}
		//y轴 销售数量
		for(StatisticsVo row:list){		
			data2.add((""+row.getCount()));	
			System.out.println(row.getCount());
		}	
		
		Map<String,Object> legend=new HashMap<>();
		
		List<String> data=new ArrayList<>();
		data.add("总销量");
		Map<String,Object> axisLabel=new HashMap<>();
		axisLabel.put("interval",0);
		axisLabel.put("rotate",-20);

		legend.put("data", data);
		xAxis.put("type", "category");
		xAxis.put("data", data1);
		xAxis.put("axisLabel", axisLabel);
		xAxis.put("name", "种类");
		yAxis.put("type", "value");
		yAxis.put("name", "总销量");
		ret.put("legend", legend);
		
		Map<String,Object> seriesInner=new HashMap<>();
		seriesInner.put("name", "总销量");
		seriesInner.put("type", "bar");
		seriesInner.put("barWidth", "50%");
		seriesInner.put("data", data2);
		series.add(seriesInner);
		Gson gson=new Gson();
		String r=gson.toJson(ret);
		return r;
		
	}
	
	@ResponseBody
	@GetMapping("back/fAll")
	public String fAll(){
		
		List<StatisticsVo> list=om.selectStatistics();
		Map<String,Object> legend=new HashMap<>();
		Map<String,Object> tooltip=new HashMap<>();
		Map<String,Object> ret=new HashMap<>();
		
		tooltip.put("trigger", "item");
			
		List<String> data=new ArrayList<>();
		for(StatisticsVo v:list){
			data.add(""+v.getVname());
		}
		legend.put("data", data);
		legend.put("orient", "vertical");
		legend.put("left", 10);
		
		List<Map<String,Object>> series=new ArrayList<>();
		Map<String,Object> seriesInner=new HashMap<>();
		
		seriesInner.put("name", "总销量");
		seriesInner.put("type", "pie");
		seriesInner.put("avoidLabelOverlap", false);
		
		List<String> radius=new ArrayList<>();
		radius.add("50%");
		radius.add("70%");
		seriesInner.put("radius",radius);
		
		Map<String,Object> label=new HashMap<>();
		Map<String,Object> normal=new HashMap<>();
		Map<String,Object> emphasis=new HashMap<>();
		
		normal.put("show", false);
		normal.put("position", "center");
		label.put("normal", normal);
		emphasis.put("show", true);
		
		Map<String,Object> textStyle=new HashMap<>();
		textStyle.put("fontSize", "13");
		textStyle.put("fontWeight", "blod");
		emphasis.put("textStyle", textStyle);
		label.put("emphasis", emphasis);
		
		Map<String,Object> labelLine=new HashMap<>();
		Map<String,Object> normal2=new HashMap<>();
		normal2.put("show", false);
		labelLine.put("normal", normal2);
		
		seriesInner.put("labelLine", labelLine);
		List<Map<String,Object>> data2=new ArrayList<>();
		Map<String,Object> value=null;
		
		for(StatisticsVo v:list){
			value=new HashMap<>();
			value.put("value", v.getCount());
			value.put("name", v.getVname());
			data2.add(value);
		}
		
		seriesInner.put("data", data2);
		series.add(seriesInner);
		ret.put("tooltip",tooltip);
	
		ret.put("series",series);
	
		ret.put("legend", legend);
		Gson gson=new Gson();
		String r=gson.toJson(ret);
		return r;
	}
	
	
	@ResponseBody
	@GetMapping("back/nearSales")
	public String nearWeek(){

		List<NearWeekVo> list=orm.selectStatistics();
		
		Map<String,Object> ret=new HashMap<>();
		
		Map<String,Object> xAxis=new HashMap<>();
		Map<String,Object> yAxis=new HashMap<>();
		List<Map<String,Object>> series=new ArrayList<>();
		
		Map<String,Object> tooltip=new HashMap<>();
		
		Map<String,Object> axisPointerInner=new HashMap<>();
		List<String> color=new ArrayList<>();
		color.add("blue");
		Map<String,Object> legend=new HashMap<>();
		
		List<String> data=new ArrayList<>();
		data.add("日销量");

		legend.put("data", data);
		ret.put("tooltip",tooltip);
		ret.put("xAxis", xAxis);
		ret.put("yAxis", yAxis);
		ret.put("series",series);
		ret.put("color", color);
		ret.put("legend", legend);
		
		tooltip.put( "trigger", "axis");
		
		axisPointerInner.put( "type", "shadow");
		tooltip.put( "axisPointer", axisPointerInner);
		
		List<String> data1=new ArrayList<>();
		List<String> data2=new ArrayList<>();	
		DateFormat df2 = new SimpleDateFormat("dd");
		for(NearWeekVo v:list){
			data1.add(df2.format(v.getOrdertimes()));	
			data2.add(""+v.getCount());
		}
		
			
		xAxis.put("type", "category");
		xAxis.put("data", data1);	
		xAxis.put("name", "天/号");
		yAxis.put("type", "value");
		yAxis.put("name", "销量");
		
		Map<String,Object> seriesInner=new HashMap<>();
		seriesInner.put("name", "日销量");
		seriesInner.put("type", "bar");
		seriesInner.put("barWidth", "50%");
		seriesInner.put("data", data2);
		series.add(seriesInner);
		Gson gson=new Gson();
		String r=gson.toJson(ret);
		return r;
	}
	
	@ResponseBody
	@GetMapping("back/fchart")
	public String Fchart(){
		
		List<NearWeekVo> list=orm.selectStatistics();
		Map<String,Object> legend=new HashMap<>();
		Map<String,Object> tooltip=new HashMap<>();
		Map<String,Object> ret=new HashMap<>();
		
		tooltip.put("trigger", "item");
		DateFormat df2 = new SimpleDateFormat("dd");
		
		List<String> data=new ArrayList<>();
		for(NearWeekVo v:list){
			data.add(""+df2.format(v.getOrdertimes()));
		}
		legend.put("data", data);
		legend.put("orient", "vertical");
		legend.put("left", 10);
		
		List<Map<String,Object>> series=new ArrayList<>();
		Map<String,Object> seriesInner=new HashMap<>();
		
		seriesInner.put("name", "日销量");
		seriesInner.put("type", "pie");
		seriesInner.put("avoidLabelOverlap", false);
		
		List<String> radius=new ArrayList<>();
		radius.add("50%");
		radius.add("70%");
		seriesInner.put("radius",radius);
		
		Map<String,Object> label=new HashMap<>();
		Map<String,Object> normal=new HashMap<>();
		Map<String,Object> emphasis=new HashMap<>();
		
		normal.put("show", false);
		normal.put("position", "center");
		label.put("normal", normal);
		emphasis.put("show", true);
		
		Map<String,Object> textStyle=new HashMap<>();
		textStyle.put("fontSize", "13");
		textStyle.put("fontWeight", "blod");
		emphasis.put("textStyle", textStyle);
		label.put("emphasis", emphasis);
		
		Map<String,Object> labelLine=new HashMap<>();
		Map<String,Object> normal2=new HashMap<>();
		normal2.put("show", false);
		labelLine.put("normal", normal2);
		
		seriesInner.put("labelLine", labelLine);
		List<Map<String,Object>> data2=new ArrayList<>();
		Map<String,Object> value=null;
		
		for(NearWeekVo v:list){
			value=new HashMap<>();
			value.put("value", v.getCount());
			value.put("name", df2.format(v.getOrdertimes()));
			data2.add(value);
		}
		
		seriesInner.put("data", data2);
		series.add(seriesInner);
		ret.put("tooltip",tooltip);
	
		ret.put("series",series);
	
		ret.put("legend", legend);
		Gson gson=new Gson();
		String r=gson.toJson(ret);
		return r;
	}
	@ResponseBody
	@GetMapping("back/YearTotal")
	public List<NearWeekVo> YearTotal(){
		
		List<NearWeekVo> list=new ArrayList<>();
		
		NearWeekVo near=null;
		List<Order> olist=null;
		OrderExample oe=null;

		Date d=new Date();
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		calendar.set(year, 0,1);
		calendar.add(Calendar.YEAR, -5);
		d=calendar.getTime();
		Date time1=null;
		Date time2=null;
		int count=0;
		for(int n=5;n>=0;n--){
			olist=new ArrayList<>();
			near=new NearWeekVo();
			oe=new OrderExample();
			time1=new Timestamp(d.getTime());
			calendar.add(Calendar.YEAR, +1);
			d=calendar.getTime();
			time2=new Timestamp(d.getTime());
			oe.createCriteria().andOrdertimeBetween(time1, time2);
			olist=orm.selectByExample(oe);
			if(olist!=null||olist.size()>=0){
			for(int i=0;i<olist.size();i++){
				if(olist.get(i).getTemp3()!=null){
				count+=olist.get(i).getTemp3();
					}
				}
			}
			near.setCount(count);
			count=0;		
			near.setOrdertimes(time1);
			list.add(near);		
		}	
		return list;
	}

}
