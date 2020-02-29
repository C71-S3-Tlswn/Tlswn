package com.tlswn.C71S3Tlswndemo.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tlswn.C71S3Tlswndemo.bean.Admin;
import com.tlswn.C71S3Tlswndemo.bean.AdminExample;
import com.tlswn.C71S3Tlswndemo.bean.Evaluate;
import com.tlswn.C71S3Tlswndemo.bean.EvaluateExample;
import com.tlswn.C71S3Tlswndemo.bean.User;
import com.tlswn.C71S3Tlswndemo.dao.AdminMapper;
import com.tlswn.C71S3Tlswndemo.dao.EvaluateMapper;

@Service
public class EvaluateBiz {
	
	@Resource
	private EvaluateMapper em;
	
	public int publish(Evaluate ev,HttpSession sess) throws BizException{
		User user=(User) sess.getAttribute("User");
		ev.setUid(user.getUid());
		
		try {
			Date d=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date etime = sdf.parse(sdf.format(d));
			ev.setEtime(etime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(ev.getContent().isEmpty()){
			ev.setContent("无评论内容");
		}
		
		if(ev.getEimg().isEmpty()){
			ev.setEimg(null);
		}
		int re=em.insert(ev);
		return re;
	}
}
