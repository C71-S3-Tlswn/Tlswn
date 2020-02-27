package com.tlswn.C71S3Tlswndemo.backweb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Stock;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.StockMapper;

@Controller
public class GoodAction {

	@Resource
	private CommodityMapper cm;
	@Resource
	private StockMapper sm;
	
	@GetMapping("back/goodtables")
	public String showGood(Model m){
		/*List<Stock> list=new ArrayList<Stock>();
		List<Commodity> li=new ArrayList<Commodity>();
		list=sm.selectByExample(null);
		for(int i=0;i<list.size();i++){
			String space=null;
			space=list.get(i).getSpecs();
			li.add(i, );
			
		}
		CommodityExample ce=new CommodityExample();*/
		
		m.addAttribute("comm", cm.selectByExample(null));
		
		return "back/goodtables";
	}
	
	@GetMapping("back/storetables")
	public String showStore(Model m1){
		
		m1.addAttribute("store", sm.selectByExample(null));
		return "back/storetables";
	}
	
	@GetMapping("back/addforms")
	public String add(Model m1){
		
		//m1.addAttribute("store", sm.selectByExample(null));
		return "back/addforms";
	}
}
