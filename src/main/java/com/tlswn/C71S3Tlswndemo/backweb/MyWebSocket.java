package com.tlswn.C71S3Tlswndemo.backweb;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@ServerEndpoint(value="/websocket/{username}")
@Component
public class MyWebSocket {

	private static Hashtable<String, Session> sessionTable=new Hashtable<>();
	
	/**
	 * 连接成功调用的方法，那么Session 对象会被容器创建
	 * @param session
	 */
	@OnOpen
	public void onOpen(@PathParam("username") String username,Session session){
		sessionTable.put(username, session);
	}
	//连接关闭调用的方法
	@OnClose
	public void onClose(@PathParam("username") String username){
		sessionTable.remove(username);
	}
	@OnMessage
	public void onMessage(@PathParam("username") String username,String message,Session session) throws IOException{
		String[] idAndMsg=message.split(":");
		System.out.println(message);
		Session destSession =sessionTable.get(idAndMsg[1]);
		if(destSession!=null){
			destSession.getBasicRemote().sendText(idAndMsg[0]+idAndMsg[2]);
		}else{
			System.out.println("目标用户不再线"+idAndMsg[1]);
		}
		System.out.println(message);
	}
	
	/*public void sendMessageTo(String message,String from, String ToUserName) throws IOException {
			
		MyWebSocket
		
	    }*/
	
}
