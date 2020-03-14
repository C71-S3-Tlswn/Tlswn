package com.tlswn.C71S3Tlswndemo.listener;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.util.SetMap;

@WebListener
public class SeeListener implements ServletRequestListener{
	@Resource
	CommodityMapper cm;
	private HashMap<Integer, ArrayList> map = new HashMap<>();
	
	@Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
 
        /*logger.info("------------------请求销毁");*/
    }
 
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest httpservletRequest = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String url=httpservletRequest.getRequestURI();
        if(url.indexOf("single_")!=-1){
        	User user=(User) httpservletRequest.getSession().getAttribute("User");
        	int suburl=Integer.valueOf(url.substring(url.lastIndexOf("_")+1));
        	if(SetMap.put(user.getUid(), suburl, map)){
        		int num=0;
        		if(cm.selectByPrimaryKey(suburl).getTemp()==null){
        			num=1;
        		}else{
        			num=Integer.valueOf(cm.selectByPrimaryKey(suburl).getTemp())+1;
        		}
        		Commodity cd=new Commodity();
        		cd.setCid(suburl);
        		cd.setTemp(String.valueOf(num));
        		cm.updateByPrimaryKeySelective(cd);
        	}
        }
    }

}
