package com.tlswn.C71S3Tlswndemo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Addr;
import com.tlswn.C71S3Tlswndemo.bean.AddrExample;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Favorite;
import com.tlswn.C71S3Tlswndemo.bean.FavoriteExample;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.bean.TypeExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.bean.UserExample;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.FavoriteMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.TypeMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;
import com.tlswn.C71S3Tlswndemo.dao.VarietyMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;



@Controller
public class AddrAction {
	@Resource
	private UserMapper us;
	@Resource
	private AddrMapper ad;
	@Resource
	private FavoriteMapper fa;
	@Resource
	private CommodityMapper cm;
	@Resource
	private OrderMapper om;
	
	@Resource
	private VarietyMapper vm;
	@Resource
	private TypeMapper tm;
	
	@GetMapping({"addr","addr.do"})
	public String dizhi(){
		return "addr";
	}
	@GetMapping("myself")
	public String Myself(Model m,HttpSession hs){
		User user=(User) hs.getAttribute("User");
		if(user==null){
			return "login";
		}
		UserExample ue=new UserExample();
		com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
		User uu=us.selectByPrimaryKey(user.getUid());
		System.out.println(user.getUsex());
	    if(uu.getUsex()==1){
	    	m.addAttribute("ss","男");
	    }else{
	    	m.addAttribute("ss", "女");
	    }
		m.addAttribute("User",uu);
	
		return "myself";
	}
	@ResponseBody
	@PostMapping("bh.do")
	public Result dizi(@Valid Addr addr,String uname){
	    List<Addr> list=new ArrayList<>();
		UserExample ue=new UserExample();
		AddrExample add=new AddrExample();
		Integer cc;
		int v;
		//Addr ar=new Addr();
		Addr ar1=new Addr();
		//构建条件e
		com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
		c.andUnameEqualTo(uname);
	   cc= us.selectByExample(ue).get(0).getUid();//查出对应uid
	   addr.setUid(cc);
	 /*  com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria ca=add.createCriteria();
	   ca.andUidEqualTo(cc);
	   list=ad.selectByExample(add);
	   for(int i=0;i<list.size();i++){
		   if(list.get(i).getAstatus()==1){
//			   com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cav=add.createCriteria();
//			   cav.andAidEqualTo(list.get(i).getAid());
			ar= ad.selectByPrimaryKey(list.get(i).getAid());			
		   }
		   	}*/
	   System.out.println(addr.getAstatus());
	   if(addr.getAstatus()==1){
		   com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria ca=add.createCriteria();
		   ca.andUidEqualTo(cc);
		   list=ad.selectByExample(add);
		   if(!list.isEmpty()){
			   ar1.setAstatus(0);
			   com.tlswn.C71S3Tlswndemo.bean.AddrExample.Criteria cav=add.createCriteria();
			   cav.andUidEqualTo(cc);
			   ad.updateByExampleSelective(ar1, add);			
			   v=ad.insert(addr);
		   }else{
				 v=ad.insert(addr);
		   }
		   
	
		 if(v==1){
			   return new Result(1, "更改默认地址成功");
		   }else{
			   return new Result(2, "地址操作失败");
		   }
	   }else{
		   v= ad.insert(addr);
		  if(v==1){
			   return new Result(1, "地址操作成功");
		   }else{
			   return new Result(2, "地址操作失败");		   
	   }			
	   }	   
	}
	/*@Value("${file.upload.path}")
	private String filePath;*/
	
	/*@PostMapping("upload.do")
	private void tou(@RequestParam("file") MultipartFile file,  HttpServletRequest request,HttpServletResponse response,HttpSession hs,Model model) throws IOException, ServletException{
		User user=new User();
		User use=(User) hs.getAttribute("User");
		UserExample ue=new UserExample();
		
		//获取上传文件名
		String filename=file.getOriginalFilename();
		//定义上传文件保存路径
		String path=filePath+"rotPhoto/";
		//新建文件
		File filepath=new File(path,filename);
		//判断路径是否存在，如果不存在就创建一个
		if(!filepath.getParentFile().exists()){
			filepath.getParentFile().mkdirs();
		}
		try{
		 //写入文件
		file.transferTo(new File(path+File.separator+filename));
		}catch(IOException e){
			e.printStackTrace();
		}
		//将src路径发送至html页面
		model.addAttribute("filename", "/images/rotPhoto/"+filename);
		
		

				
		user.setUphoto( "/images/rotPhoto/"+filename);
		com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
		c.andUidEqualTo(use.getUid());
		int cl=us.updateByExampleSelective(user, ue);
		
		response.getWriter().append("success");
		
	}*/
	
	//测试
	@ResponseBody
	@PostMapping("upload.do")
	public Result saveGoodsPage(MultipartFile file,@Value("${user.file.path}") String filePath,HttpSession hs){
		User user=new User();
		User use=(User) hs.getAttribute("User");
		UserExample ue=new UserExample();
		
		String fileName=null;
		try {
			// 保存图片
			/*File file = new File(filePath + img.getOriginalFilename());*/
			File files=new File(filePath);
			System.out.println(filePath);
			if(!files.exists()){
				files.mkdirs();
			}
			System.out.println(files);
			fileName=file.getOriginalFilename();
			System.out.println(fileName);
			files=new File(filePath + fileName);
			
			file.transferTo(files);
			user.setUphoto(fileName);
			com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
			c.andUidEqualTo(use.getUid());
			int cl=us.updateByExampleSelective(user, ue);
			if(cl==1){
				return new Result(1, "更改成功");
			}else{
				return new Result(0, "更改失败");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(0, "更改失败");
		}
	       
		
	}
	
	@ResponseBody
	@PostMapping("shoucang")
	public Result shoucang(@Valid Commodity com,HttpSession hs){
		Favorite faa=new Favorite();
		User use=(User) hs.getAttribute("User");
		FavoriteExample fac=new FavoriteExample(); 
		List<Favorite> lis=new ArrayList<Favorite>();
		if(use==null){
			return new Result(3, "请登录");
		}
		faa.setUid(use.getUid());
		faa.setTemp3(com.getCid());
		com.tlswn.C71S3Tlswndemo.bean.FavoriteExample.Criteria c=fac.createCriteria();
		c.andTemp3EqualTo(com.getCid());
		lis=fa.selectByExample(fac);
		if(!lis.isEmpty()){
			return new Result(4, "您已收藏过该商品");
		}
		int cv=fa.insertSelective(faa);
		if(cv==1){
			return new Result(1, "收藏成功");
	}else{
		return new Result(0, "收藏失败");
	}
	}
	
	
	@PostMapping("change")
	public String change(User user,String sex,HttpServletRequest request,HttpSession hs) throws IOException, ServletException{
		UserExample ue=new UserExample();
		User use=(User) hs.getAttribute("User");
		if(sex.equals("男")){
			user.setUsex(1);
		}else{
			user.setUsex(2);
		}
		user.setUname(use.getUname());
		com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
		c.andUidEqualTo(use.getUid());
		int k=us.updateByExampleSelective(user, ue);
	System.out.println(k);
		return "index";
	}
	@GetMapping("favorite")
	 public String favorite(HttpSession hs,Model model){
		FavoriteExample fac=new FavoriteExample();
		CommodityExample co=new CommodityExample();
		List<Favorite> list=new ArrayList<Favorite>();
		List<Commodity> li=new ArrayList<Commodity>();
		User user=(User) hs.getAttribute("User");
		if(user==null){
			return "login";
		}
		com.tlswn.C71S3Tlswndemo.bean.FavoriteExample.Criteria c=fac.createCriteria();
		c.andUidEqualTo(user.getUid());
		list=fa.selectByExample(fac);
		for(int i=0;i<list.size();i++){
			int cid=0;
			cid=list.get(i).getTemp3();
			li.add(i, cm.selectByPrimaryKey(cid));//根据 id查商品
			li.get(i).setCid(cid);
		}
		model.addAttribute("li", li);
		 return "favorite";
	 }
	@ResponseBody
	@GetMapping("dele.do")
	public Result dele(@Valid Commodity com,Model m) throws IOException{
	FavoriteExample fac=new FavoriteExample();
	com.tlswn.C71S3Tlswndemo.bean.FavoriteExample.Criteria c=fac.createCriteria();
	c.andTemp3EqualTo(com.getCid());
	System.out.println(com.getCid());
	int cs=fa.deleteByExample(fac);
	if(cs==1){
			return new Result(1, "删除成功");
	}else{
		return new Result(0, "删除失败");
	}}
	
	
	@GetMapping("order")
	public String order(HttpSession hs,Model m){
		List<Commodity> cmc=new ArrayList<Commodity>();
		List<Order> list=new ArrayList<Order>();
		User user=(User) hs.getAttribute("User");
		OrderExample or=new OrderExample();
		com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria c=or.createCriteria();
		 c.andUidEqualTo(user.getUid());
		 c.andTempEqualTo("1");
		System.out.println("-------------------------------------------------------------------------------------");
      list= om.selectByExample(or);
		System.out.println("=======================================================================================");
for(int i=0;i<list.size();i++){
	if(list.get(i).getArrivetime()!=null){
		list.get(i).setPs("已送达"); 
	}else if(list.get(i).getDelivetime()!=null&&list.get(i).getArrivetime()==null){
		list.get(i).setPs("已发货");
	}else if(list.get(i).getOrdertime()!=null&&list.get(i).getDelivetime()==null&&list.get(i).getArrivetime()==null){
		list.get(i).setPs("未发货");
	}
   list.get(i).setTemp(cm.selectByPrimaryKey(list.get(i).getCid()).getCname());
   list.get(i).setTemp2(cm.selectByPrimaryKey(list.get(i).getCid()).getCphoto());
		}
		m.addAttribute("li", list);
		return "order";
	}
	
	@ResponseBody
	@GetMapping("shan")
	public Result shan(@Valid Order ord,Model m) throws IOException{
	OrderExample or=new OrderExample();
	com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria c=or.createCriteria();
	c.andOidEqualTo(ord.getOid());
	ord.setTemp("0");
	System.out.println(ord.getOid());
	int cs=om.updateByExampleSelective(ord, or);
	if(cs==1){
			return new Result(1, "删除成功");
	}else{
		return new Result(0, "删除失败");
	}}
	
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
