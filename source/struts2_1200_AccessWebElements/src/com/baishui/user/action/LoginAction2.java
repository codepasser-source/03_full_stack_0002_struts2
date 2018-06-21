package com.baishui.user.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction2 extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		 
		this.session=session;
		
	}

	private UserModel user;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public String execute() throws Exception {
		 
		System.out.println(user.name);
		System.out.println(user.age);
		session.put("user", user);
		
		return this.SUCCESS;
	}
	
	
	
}
