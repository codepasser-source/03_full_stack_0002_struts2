package com.baishui.user.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

 
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction3 extends ActionSupport {

	private HttpSession session ;

	public LoginAction3() {
	   session = ServletActionContext.getRequest().getSession();
	   
	}
	
	private UserModel user;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

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
		
		
		return this.SUCCESS;
	}
	
	
	
	
}
