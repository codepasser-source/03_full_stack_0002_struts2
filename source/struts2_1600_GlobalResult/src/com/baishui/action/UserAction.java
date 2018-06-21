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

		System.out.println("type="+type);
		if (this.type == 1) {
			return SUCCESS;
		} else if (this.type == 2) {
			return "error"; 
		}else{
			return "mainpage";
		}

	}

}
