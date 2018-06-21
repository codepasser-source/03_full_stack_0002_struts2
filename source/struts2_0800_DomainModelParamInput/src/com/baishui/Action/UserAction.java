package com.baishui.Action;

import com.baishui.Model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserModel user;
	
	
	
@Override
public String execute() throws Exception {
	 
	if(!user.getName().equals("tom")&&!user.getPassword().equals("123456")){
		
		this.addFieldError("loginError", "user or password is error");
		return this.INPUT;
	}
	 
	
	return this.SUCCESS;
}



public UserModel getUser() {
	return user;
}



public void setUser(UserModel user) {
	this.user = user;
}



	
}
