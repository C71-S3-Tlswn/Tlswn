package com.tlswn.C71S3Tlswndemo.backweb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Stock;
import com.tlswn.C71S3Tlswndemo.bean.StockExample;
import com.tlswn.C71S3Tlswndemo.bean.Type;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.Variety;
import com.tlswn.C71S3Tlswndemo.bean.VarietyExample;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.StockMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class GoodAction {

	@Resource
	private CommodityMapper cm;
	@Resource
	private TypeMapper tm;
	@Resource
	private VarietyMapper vm;
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
		m1.addAttribute("type", tm.selectByExample(null));
		m1.addAttribute("vari", vm.selectByExample(null));
		return "back/addforms";
	}
	
	@GetMapping("back/changeforms_{id}")
	public String change(@PathVariable("id") Integer id,Model m){
		CommodityExample ce=new CommodityExample();
		Commodity comm=cm.selectByPrimaryKey(id);
		m.addAttribute("change", comm);
		return "back/changforms";
	}
	
	@ResponseBody
	@PostMapping("back/type")
	public void type(Variety var,Type type,Model m3){
		VarietyExample ve=new VarietyExample();
		ve.createCriteria().andVnameEqualTo(var.getVname());
		List<Variety> list=vm.selectByExample(ve);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			type.setVid(list.get(i).getVid());
		}
		//System.out.println(type.getVid());
		TypeExample te=new TypeExample();
		te.createCriteria().andVidEqualTo(type.getVid());
		List<Type> tt=tm.selectByExample(te);
		System.out.println("--------------------"+tt.size());
		m3.addAttribute("types", tt);
		List<Type> tt1=(List<Type>) m3.getAttribute("types");
		System.out.println(tt1.size());
		//return tt;
		/*return "back/addforms";*/
	}
	
	@ResponseBody
	@PostMapping("back/add")
	public Result adds(String cname, String tname,String vname,
			Commodity comm,Stock stock,
			MultipartFile file, @Value("${user.file.path}")String filePath){
		TypeExample te=new TypeExample();
		CommodityExample ce=new CommodityExample();
		List<Commodity> commodity=new ArrayList<Commodity>();
		List<Type> type=new ArrayList<Type>();
		//comm.setCnum(num);
		
		try {
			File files=new File(filePath);
			System.out.println(filePath);
			if(!files.exists()){
				files.mkdirs();
			}
			System.out.println(files);
			//System.out.println(cphoto);
			String fileName=file.getOriginalFilename();
			System.out.println(fileName);
			files=new File(filePath + fileName);
			
			file.transferTo(files);
			//System.out.println(filePath);
			comm.setCphoto(fileName);
		ce.createCriteria().andCnameEqualTo(cname);
		commodity=cm.selectByExample(ce);
		te.createCriteria().andTnameEqualTo(tname);
		type=tm.selectByExample(te);
		for(int i=0;i<type.size();i++){
			comm.setTid(type.get(i).getTid());
		}
		/*for(int i=0;i<commodity.size();i++){
			stock.setCid(commodity.get(i).getCid());
		}*/
		comm.setCnum(0);
		comm.setTemp2(100);
		int cl=cm.insertSelective(comm);
		//int sl=sm.insertSelective(stock);
		if(cl==1){
			return new Result(1, "添加成功");
		}else{
			return new Result(0,"shibai");
		}
		}catch (IOException e) {
			e.printStackTrace();
			return new Result(0, "更改失败");
		}
		 
	
	}
	
	
	@PostMapping("back/change")
	@ResponseBody
	public Result change(Commodity com,Stock st,String cname){
		CommodityExample ce=new CommodityExample();
		CommodityExample ce2=new CommodityExample();
		StockExample se=new StockExample();
		ce.createCriteria().andCnameEqualTo(cname);
		
		//cm.updateByExampleSelective(com, ce);
		List<Commodity> list=new ArrayList<>();
		List<Stock> stock=new ArrayList<>();
		ce2.createCriteria().andCnameEqualTo(cname);
		list=cm.selectByExample(ce2);
		int cid=0;
		for (int i = 0; i <list.size(); i++) {
			cid=list.get(i).getCid();
		}
		if(st.getColor()==null&&st.getSpecs()==null){
			cm.updateByExampleSelective(com, ce);
		}else{
		se.createCriteria().andSpecsEqualTo(st.getSpecs())
		.andColorEqualTo(st.getColor()).andCidEqualTo(cid);
		stock=sm.selectByExample(se);
		if(stock.isEmpty()){
			
			st.setCid(cid);
			sm.insert(st);
			com.setCnum(st.getNum());
			cm.updateByExampleSelective(com, ce);
		}else{
			sm.updateByExampleSelective(st, se);
			com.setCnum(st.getNum());
			cm.updateByExampleSelective(com, ce);
		}
		}
		return new Result(1, "11212");
	}
	
	@PostMapping("back/sale")
	@ResponseBody
	public Result sale(Commodity commm){
		CommodityExample ce=new CommodityExample();
		ce.createCriteria().andCnameEqualTo(commm.getCname());
		int a=cm.updateByExampleSelective(commm, ce);
		if(a==1){
			return new Result(1, "修改成功");
		}else{
			return new Result(0, "修改失败");
		}
		
	}

/*String fileName=null;
 * try {
	File files=new File(filePath);
	if(!files.exists()){
		files.mkdirs();
	}
	fileName=file.getOriginalFilename();
	files=new File(filePath + fileName);
	
	file.transferTo(files);
	comm.setCphoto(fileName);
}catch (IOException e) {
	e.printStackTrace();
	return new Result(0, "更改失败");
}*/
}
