package com.baishui.action;

 
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

 
	private int type;
 
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	 

	public String add() { 
 
		return SUCCESS;
	}

}
