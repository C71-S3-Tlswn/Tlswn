package com.tlswn.C71S3Tlswndemo.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;

@Controller
public class PaymentController {
	@Resource
	private CommodityMapper comd;
	@Resource
	private OrderMapper om;
    @RequestMapping("pay")
    public void payMent(String id,HttpServletResponse response, HttpServletRequest request) {
    	List<Order> lisr=new ArrayList<>();
    	AlipayServiceImpl alipayService=new AlipayServiceImpl();
    	System.out.println(id);   	
		OrderExample od=new OrderExample();
    	Order oof=new Order();
    	Double maney=0.0;
	com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria cv=od.createCriteria();
	cv.andTemp2EqualTo(id);
	lisr=om.selectByExample(od);
for(int i=0;i<lisr.size();i++){
	maney+=lisr.get(i).getOprice();
}
System.out.println("ssssss="+maney);
 //对应生成订单的oid	我需要根据oid来成功支付更改它的状态	
        try {
            alipayService.aliPay(response,request,String.valueOf(maney),"筐筐商城",id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("eva")
    public String mo(String oid){    	
    	Order ore=new Order();
    	OrderExample od=new OrderExample();    	    
    		System.out.println("aaaaa"+oid);
    		com.tlswn.C71S3Tlswndemo.bean.OrderExample.Criteria cv=od.createCriteria();
    		cv.andTemp2EqualTo(oid);
    		ore.setStatus(1);
        	om.updateByExampleSelective(ore,od);      	   	
    	return "index";
    }
}
