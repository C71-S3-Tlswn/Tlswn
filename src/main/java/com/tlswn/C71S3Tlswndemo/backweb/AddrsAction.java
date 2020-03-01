package com.tlswn.C71S3Tlswndemo.backweb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.bean.Orderitem;
import com.tlswn.C71S3Tlswndemo.bean.UserExample;
import com.tlswn.C71S3Tlswndemo.dao.CommodityMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;
import com.tlswn.C71S3Tlswndemo.dao.OrderitemMapper;
import com.tlswn.C71S3Tlswndemo.dao.UserMapper;
import com.tlswn.C71S3Tlswndemo.vo.Result;

@Controller
public class AddrsAction {
@Resource
private OrderMapper om;
@Resource
private CommodityMapper cm;
@Resource
private UserMapper us;
@Resource
private OrderitemMapper orm;
@GetMapping("back/order")	
public String order(Model m){
	OrderExample or=new OrderExample();
	UserExample ue=new UserExample();
	CommodityExample co=new CommodityExample();
	List<Order> li=new ArrayList<Order>();

	List<Order> li2=new ArrayList<Order>();
	List<Order> li3=new ArrayList<Order>();
	List<Order> li4=new ArrayList<Order>();
	List<Order> li5=new ArrayList<Order>();
	li=om.selectByExample(or);
	for(int i=0;i<li.size();i++){
		if(li.get(i).getStatus()==0){
			Order oov=new Order();
			oov.setTemp(us.selectByPrimaryKey(li.get(i).getUid()).getUname());
			oov.setTemp2(cm.selectByPrimaryKey(li.get(i).getCid()).getCname());
			oov.setOaddr(li.get(i).getOaddr());
			oov.setOtel(li.get(i).getOtel());
			oov.setOprice(li.get(i).getOprice());
			oov.setPstatus(li.get(i).getPstatus());
			oov.setStatus(li.get(i).getStatus());
			oov.setTemp3(li.get(i).getTemp3());
			oov.setPs(li.get(i).getPs());
			oov.setOid(li.get(i).getOid());
			li5.add(oov);
		}else if(li.get(i).getDelivetime()==null&&li.get(i).getStatus()==1){
		Order oo=new Order();
		oo.setTemp(us.selectByPrimaryKey(li.get(i).getUid()).getUname());
		oo.setTemp2(cm.selectByPrimaryKey(li.get(i).getCid()).getCname());
		oo.setOaddr(li.get(i).getOaddr());
		oo.setOtel(li.get(i).getOtel());
		oo.setOrdertime(li.get(i).getOrdertime());
		oo.setOprice(li.get(i).getOprice());
		oo.setPstatus(li.get(i).getPstatus());
		oo.setTemp3(li.get(i).getTemp3());
		oo.setPs(li.get(i).getPs());
		oo.setOid(li.get(i).getOid());
	    li2.add(oo);
		}else if(li.get(i).getDelivetime()!=null&&li.get(i).getArrivetime()==null){
			Order oo1=new Order();
			oo1.setOid(li.get(i).getOid());
			oo1.setTemp(us.selectByPrimaryKey(li.get(i).getUid()).getUname());
			oo1.setTemp2(cm.selectByPrimaryKey(li.get(i).getCid()).getCname());
			oo1.setOaddr(li.get(i).getOaddr());
			oo1.setOtel(li.get(i).getOtel());
			oo1.setOrdertime(li.get(i).getOrdertime());
			oo1.setDelivetime(li.get(i).getDelivetime());
			oo1.setOprice(li.get(i).getOprice());
			oo1.setPstatus(li.get(i).getPstatus());
			oo1.setTemp3(li.get(i).getTemp3());
			oo1.setPs(li.get(i).getPs());
			li3.add(oo1);
		}else if(li.get(i).getArrivetime()!=null){
			Order oo2=new Order();
			oo2.setOid(li.get(i).getOid());
			oo2.setTemp(us.selectByPrimaryKey(li.get(i).getUid()).getUname());
			oo2.setTemp2(cm.selectByPrimaryKey(li.get(i).getCid()).getCname());
			oo2.setOaddr(li.get(i).getOaddr());
			oo2.setOtel(li.get(i).getOtel());
			oo2.setOrdertime(li.get(i).getOrdertime());
			oo2.setDelivetime(li.get(i).getDelivetime());
			oo2.setOprice(li.get(i).getOprice());
			oo2.setPstatus(li.get(i).getPstatus());
			oo2.setTemp3(li.get(i).getTemp3());
			oo2.setArrivetime(li.get(i).getArrivetime());
			oo2.setPs(li.get(i).getPs());
			li4.add(oo2);
		}
	}
	m.addAttribute("li2", li2);
	m.addAttribute("li3", li3);
	m.addAttribute("li4", li4);
	m.addAttribute("li5", li5);
	return "back/tables";
}
@ResponseBody
@GetMapping("back/fa.do")
public Result fahuo(@Valid Order or,Model m){
	OrderExample op=new OrderExample();
	Date date=new Date();
//	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String data=dateFormat.format(date);
	or.setDelivetime(date);
   int vv=om.updateByPrimaryKeySelective(or);
   if(vv==1){
		return new Result(1, "操作成功");
   }else{
	   return new Result(2, "操作失败");
   }
}
@ResponseBody
@GetMapping("back/shou.do")
public Result shouhuo(@Valid Order or,Model m){
	Date date=new Date();
	Order li=new Order();
	Orderitem it=new Orderitem();
//	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String data=dateFormat.format(date);
	or.setArrivetime(date);
   int vv=om.updateByPrimaryKeySelective(or);
    li=om.selectByPrimaryKey(or.getOid());
    it.setCid(li.getCid());
    it.setCount(li.getTemp3());
    it.setPrice(li.getOprice());
  int i= orm.insertSelective(it);
   if(vv==1&&i==1){
		return new Result(1, "操作成功");
   }else{
	   return new Result(2, "操作失败");
   }
}
}
