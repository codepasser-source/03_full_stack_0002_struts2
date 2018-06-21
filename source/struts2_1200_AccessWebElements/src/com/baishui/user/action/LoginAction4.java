package com.baishui.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction4 extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	
	
	
	public void setServletRequest(HttpServletRequest request) {
	 

		this.request = request;
		session = request.getSession();
		
	}
	
	private UserModel user;



	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		 System.out.println(user.name);
		 System.out.println(user.age);
		 session.setAttribute("user", user);
		return SUCCESS;
	}
	
	
	

}
