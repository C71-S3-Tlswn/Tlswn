package com.tlswn.C71S3Tlswndemo.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Type;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample.Criteria;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;

@Controller
public class WemenAction {
	
	private final static int Page_index=9;

	@Resource
	private CommodityMapper cm;
	
	@Resource
	private TypeMapper tm;
	
	//分页查询
	@GetMapping("women")
	public String Women(Integer page,Model m){
		TypeExample te=new TypeExample();
		Criteria c=te.createCriteria();
		c.andVidEqualTo(3);
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
		List<Commodity> plist=cm.selectByExample(ce);
		PageInfo<Commodity> pageInfo=new PageInfo<>(plist);
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
		m.addAttribute("pages",pages );
		m.addAttribute("wlist", plist);
		return "women";
	}

}
