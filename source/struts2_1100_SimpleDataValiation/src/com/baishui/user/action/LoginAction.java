package com.baishui.user.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String password;
	
	@Override
	public String execute() throws Exception {
		 
		return  SUCCESS;
	}
	
	@Override
	public void validate() {
		 
		if(!this.name.equals("tom")&&!this.password.equals("tom")){
			
			this.addFieldError("loginError", "必须输入tom");
//			this.addActionError("登陆失败！");
//			this.addActionError("用户名不正确！");
		}else{
			
			this.addActionMessage("登陆成功");
		}
		
		
		
	}

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
	
	
}
