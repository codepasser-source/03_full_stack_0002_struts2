package com.baishui.actions.user;

 
 
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.baishui.form.user.UserForm;
import com.baishui.manager.user.UserManager;
import com.baishui.model.user.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	 private UserForm userForm;
	 
	
	
	@Override
	public String execute() throws Exception {
		
		
		UserModel userModel = new UserModel();
		userModel.setName(userForm.getName());
		userModel.setPassword(userForm.getPassword());
		
		UserManager userManager = new UserManager();
		
		boolean isLogin = userManager.userLogin(userModel);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("user", userModel);
		
		if(isLogin){
			 return this.SUCCESS;
		}else{ 
			return this.ERROR;
		}
	  
		
		
	}



	public UserForm getUserForm() {
		return userForm;
	}



	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}



 

 
    
	
}
