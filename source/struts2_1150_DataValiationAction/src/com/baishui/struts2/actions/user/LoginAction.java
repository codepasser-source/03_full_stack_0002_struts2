package com.baishui.struts2.actions.user;

import com.baishui.struts2.form.user.UserForm;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private UserForm userForm;

	@Override
	public String execute() throws Exception {
        System.out.println("-----LoginAction execute()--------------");
		System.out.println("登陆成功！");

		return SUCCESS;
	}

	@Override
	public void validate() {
		System.out.println("-----------LoginAction validate()-------------");
		if (!"tom".equals(userForm.getName())) {

			System.out.println("INPUT");
			this.addFieldError("nameError", "必须输入tom");
			this.addActionError("登陆失败！");
			this.addActionError("用户名不正确！");
		} else { 
			this.addActionMessage("登陆成功!"); 
		}

	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}
	
}
