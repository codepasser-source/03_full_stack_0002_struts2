package com.baishui.Action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String age;
	
	public String add(){
		System.out.println("add method");
		if(this.name.equals("") || this.age.equals("")){
			System.out.println("name="+this.name);
			System.out.println("age="+this.age);
			
			this.addActionError("name is not null");
			this.addActionError("age is not null");
			this.addActionMessage("name is wrong");
			this.addActionMessage("age is wrong ");
			this.addFieldError("nameError", "name is error");
			this.addFieldError("ageError", "age is error");
			
			return this.INPUT;
		}else{
			
			System.out.println("name="+this.name);
			System.out.println("age="+this.age);
			this.addActionMessage("add success");
			 
			return	this.SUCCESS;	
		}
		
	 
		
	}
	
public String delete(){
		
	System.out.println("delete method");
		if(this.name.equals("") || this.age.equals("")){
			System.out.println("name="+this.name);
			System.out.println("age="+this.age);
			
			this.addActionError("name is not null");
			this.addActionError("age is not null");
			this.addActionMessage("name is wrong");
			this.addActionMessage("age is wrong ");
			this.addFieldError("nameError", "name is error");
			this.addFieldError("ageError", "age is error");
			
			return this.INPUT;
		}else{
			
			System.out.println("name="+this.name);
			System.out.println("age="+this.age);
			this.addActionMessage("add success");
			 
			return	this.SUCCESS;	
		}
		
	 
		
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
