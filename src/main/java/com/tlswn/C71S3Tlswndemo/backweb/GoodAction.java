package com.tlswn.C71S3Tlswndemo.backweb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Stock;
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
	
	@PostMapping("back/add")
	public Result adds(String cname, String tname,String vname,Commodity comm,Stock stock,
			MultipartFile file, String filePath){
		TypeExample te=new TypeExample();
		CommodityExample ce=new CommodityExample();
		List<Commodity> commodity=new ArrayList<Commodity>();
		List<Type> type=new ArrayList<Type>();
		
		ce.createCriteria().andCnameEqualTo(cname);
		commodity=cm.selectByExample(ce);
		for(int i=0;i<commodity.size();i++){
			stock.setCid(commodity.get(i).getCid());
		}
		te.createCriteria().andTnameEqualTo(tname);
		type=tm.selectByExample(te);
		for(int i=0;i<type.size();i++){
			comm.setTid(type.get(i).getTid());
		}
		int cl=cm.insertSelective(comm);
		int sl=sm.insertSelective(stock);
		if(cl==1&&sl==1){
			return new Result(1, "添加成功");
		}else{
			return new Result(0,"shibai");
		}
		 
	
	}
	

/*String fileName=null;
 * try {
	File files=new File(filePath);
	if(!files.exists()){
		files.mkdirs();
	}@Value("${commodity.file.path}")
	fileName=file.getOriginalFilename();
	files=new File(filePath + fileName);
	
	file.transferTo(files);
	comm.setCphoto(fileName);
}catch (IOException e) {
	e.printStackTrace();
	return new Result(0, "更改失败");
}*/
}
