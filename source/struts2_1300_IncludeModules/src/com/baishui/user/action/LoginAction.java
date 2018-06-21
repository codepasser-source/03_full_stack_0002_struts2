package com.baishui.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		 
		if(this.name.equals("")||this.password.equals("")){
		
			this.addActionError("user or password is null");
			return this.INPUT;
			
		}
		
		return this.SUCCESS;
	}
	
	
	
}
