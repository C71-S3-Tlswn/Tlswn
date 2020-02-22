package com.tlswn.C71S3Tlswndemo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tlswn.C71S3Tlswndemo.bean.Addr;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.bean.UserExample;
import com.tlswn.C71S3Tlswndemo.dao.AddrMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;


@Controller
public class AddrAction {
	@Resource
	private UserMapper us;
	@Resource
	private AddrMapper ad;
	
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
	@PostMapping("bh.do")
	public String dizi( Addr addr,String uname){
	    
		UserExample ue=new UserExample();
		//构建条件e
		com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
		c.andUnameEqualTo(uname);
	   Integer cc= us.selectByExample(ue).get(0).getUid();
	   addr.setUid(cc);
	  int v= ad.insert(addr);
		System.out.println("........"+v);
		return "index";
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
	@PostMapping("upload.do")
	public void saveGoodsPage(@RequestParam(value="file") MultipartFile file,HttpServletResponse response,HttpSession hs){
	
		if (!file.isEmpty()) {
	        try {
	        	User user=new User();
	    		User use=(User) hs.getAttribute("User");
	    		UserExample ue=new UserExample();
	    		
	    		
	        	String name=file.getOriginalFilename();
	            BufferedOutputStream out = new BufferedOutputStream(
	                    new FileOutputStream(new File("src/main/resources/static/images/" + name)));//保存图片到目录下
	            out.write(file.getBytes());
	          
	            out.flush();
	            out.close();
	            String filename = "images/" + name;
	            
	            //存数据库
	            user.setUphoto(filename);
	            com.tlswn.C71S3Tlswndemo.bean.UserExample.Criteria c=ue.createCriteria();
	    		c.andUidEqualTo(use.getUid());
	    		int cl=us.updateByExampleSelective(user, ue);
	            response.getWriter().append("success");
	            /*user.setTupian(filename);
	            //userRepository.save(user);//增加用户*/
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	        //...其他操作
		
		
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
	@GetMapping("order")
	 public String order(HttpSession hs){
		User use=(User) hs.getAttribute("User");
		 return "order";
	 }
}
