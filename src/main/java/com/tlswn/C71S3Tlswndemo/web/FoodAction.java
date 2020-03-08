package com.tlswn.C71S3Tlswndemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Type;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;

@Controller
public class FoodAction {
	
	private final static int Page_index=9;
	
	@Resource
	private CommodityMapper cm;
	
	@Resource
	private TypeMapper tm;
	@Resource
	private VarietyMapper vm;
	
	
	/*@GetMapping("food")
	public String index(){
		return "food";
	}*/
	//分页查询
	@GetMapping("food")
	public String Page(/*@PathVariable("id")*/ Integer page,Model m){
		TypeExample te=new TypeExample();
		Criteria c=te.createCriteria();
		c.andVidEqualTo(1);
		List<Type> list=tm.selectByExample(te);
		List<Integer> tlist=new ArrayList<Integer>(); 
		for(int i=0;i<list.size();i++){
			 int  a=list.get(i).getTid();
			 tlist.add(a);	 
		}
		CommodityExample ce=new CommodityExample();
		com.tlswn.C71S3Tlswndemo.bean.CommodityExample.Criteria ct=ce.createCriteria();
		ct.andTidIn(tlist);	
		if(page==null|| page<=1){
			page=1;
		}
		PageHelper.startPage(page, Page_index);
		List<Commodity> clist=cm.selectByExample(ce);
		PageInfo<Commodity> pageInfo=new PageInfo<>(clist);
		 //当前页
		 int pagenum=pageInfo.getPageNum();
		 //总页数
		int pages=pageInfo.getPages();
		//上一页
		int prepage=pageInfo.getPrePage();
		 //下一页
		int nextpage=pageInfo.getNextPage();
	
		//判断上一页是否为0 是 上一页为当前页 不是减一
		 if(prepage==0){
				m.addAttribute("prepage", pagenum);
			}else{
			 m.addAttribute("prepage", pagenum-1);
		 }
		//判断下一页是否为0 是为当前页 不是加一
		 if(nextpage==0){
			m.addAttribute("nextpage", pagenum);
		}else{
			m.addAttribute("nextpage", pagenum+1);
		}
		//总页数
		m.addAttribute("pages",pages);
		m.addAttribute("clist", clist);
		return "food";
	}
	@ModelAttribute
	public void init(Model m){
		m.addAttribute("variety",vm.selectByExample(null) );
		
		TypeExample te=new TypeExample();
		te.createCriteria().andVidEqualTo(1);
		m.addAttribute("type", tm.selectByExample(te));
		
		TypeExample t=new TypeExample();
		t.createCriteria().andVidEqualTo(5);
		m.addAttribute("types", tm.selectByExample(t));
	}

}
