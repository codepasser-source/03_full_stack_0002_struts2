package com.baishui.user.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction1 extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserModel user;

	Map<String, Object> session;
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		 System.out.println(user.getName());
		 System.out.println(user.getAge());
		 
		 session = (Map<String, Object>)ActionContext.getContext().get("session");
		 session.put("user",user);
		 return this.SUCCESS;
	}
	
}
