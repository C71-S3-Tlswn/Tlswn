package com.tlswn.C71S3Tlswndemo;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.fabric.xmlrpc.base.Data;
import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.dao.OrderMapper;

/*import com.tlswn.C71S3Tlswndemo.dao.UserMapper;*/

@SpringBootTest
class C71S3TlswnDemoApplicationTests {
	
	@Resource
	private OrderMapper om;
	@Test
	void contextLoads() {
		Order o=new Order();
		o.setOid(1);
		o.setCid(1);
		o.setUid(2);
		o.setOtel("15277914147");
		o.setOaddr("湖南");
		
		System.out.println(om.insert(o));
		
	}

}
