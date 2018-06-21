package com.baishui.struts2.exception;

import com.opensymphony.xwork2.ActionSupport;

public class MyException extends ActionSupport {

	@Override
	public String execute() throws Exception {
		 
		
		String s = null;
		
		System.out.println(s.length());
		
		return super.execute();
	}

	

	
	
	
}
