package com.baishui.action;

 
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

 
	private int type;
	private String forward;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String add() { 
		System.out.println("type="+type);
		if (this.type == 1) {
			this.forward="user_success.jsp";
		} else if (this.type == 2) {
			this.forward="user_error.jsp";
		} 
		System.out.println(type+"-->"+forward);
		return SUCCESS;
	}

}
