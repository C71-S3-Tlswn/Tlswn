package com.tlswn.C71S3Tlswndemo.backweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tlswn.C71S3Tlswndemo.bean.Variety;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderitemMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.NearWeekVo;
import com.tlswn.C71S3Tlswndemo.vo.StatisticsVo;

@Controller
public class SparklineAction {
	
	@Resource
	private OrderitemMapper om;
	@Resource 
	private VarietyMapper vm;
	
	@Resource
	private OrderMapper orm;
	
	@GetMapping("back/charts/sparkline")
	public String Sparkline(){
		return "back/charts/sparkline";
	}
	

	@ResponseBody
	@GetMapping("back/charts/SalesVolumer")
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
		Map<String,Object> axisLabel=new HashMap<>();
		axisLabel.put("interval",0);
		axisLabel.put("rotate",-20);

		
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
		for(Variety v:vlist){		
			data1.add((""+v.getVname()));
		}
		//y轴 销售数量
		for(StatisticsVo row:list){		
			data2.add((""+row.getPrice()));		
		}	
		
		Map<String,Object> legend=new HashMap<>();
		
		List<String> data=new ArrayList<>();
		data.add("总销额");

		legend.put("data", data);
		xAxis.put("type", "category");
		xAxis.put("data", data1);	
		xAxis.put("name", "种类");
		xAxis.put("axisLabel", axisLabel);
		yAxis.put("type", "value");
		
		yAxis.put("name", "总销额");
		ret.put("legend", legend);
		
		Map<String,Object> seriesInner=new HashMap<>();
		seriesInner.put("name", "总销额");
		seriesInner.put("type", "bar");
		seriesInner.put("barWidth", "60%");
		seriesInner.put("data", data2);
		series.add(seriesInner);
		Gson gson=new Gson();
		String r=gson.toJson(ret);
		System.out.println(r);
		return r;
		
	}
	
	@ResponseBody
	@GetMapping("back/charts/totalSales")
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
		
		seriesInner.put("name", "总销额");
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
			value.put("value", v.getPrice());
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
	@GetMapping("back/charts/WeekSales")
	public List<NearWeekVo> NearSales(){
		
		List<NearWeekVo> list=orm.selectStatistics();
		
		return list;
	}
	
	
	@InitBinder
	  protected void initBinder(WebDataBinder binder) {
		 //添加日期类型转换
		 binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	 }

}
