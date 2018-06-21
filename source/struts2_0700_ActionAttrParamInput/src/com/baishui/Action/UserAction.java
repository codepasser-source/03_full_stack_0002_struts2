package com.baishui.Action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String age;
	
	
	
@Override
public String execute() throws Exception {
	 
	if(this.name.equals("")&&this.age.equals("")){
		
		this.addFieldError("nameError", "name is null");
		return  INPUT;
	} 
	
	return  SUCCESS;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}
	
	
}
