package com.baishui.bbs.action;
 
import java.util.Collection;

import com.baishui.bbs.dao.CategoryDao;
import com.baishui.bbs.model.Category;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	/*
	 * database   :  bbs
	 * table      :  category
	 * column     : id  name  descrtiption
	 */  
	

	private CategoryDao cateDao=CategoryDao.getInstance(); 
	private  Collection<Category> categories; 
	private String name;
	private String descrtiption; 
	
	public String list() throws Exception {
        
		categories= cateDao.list(); 
		System.out.println(this.cateDao.toString());
		System.out.println(this.cateDao.conn.toString());
		return SUCCESS;
	} 
	
	public String add() throws Exception { 
		Category category = new Category();
		category.setName(name);
		category.setDescrtiption(descrtiption); 
		String msg= cateDao.insert(category);
		System.out.println(msg); 
		
		System.out.println(this.cateDao.toString());
		System.out.println(this.cateDao.conn.toString());
		return SUCCESS;
	}
	
	public String delete() throws Exception { 
		return SUCCESS;
	}
	
	public String update() throws Exception { 
		return SUCCESS;
	}
	
	public String addInput() throws Exception { 
		return SUCCESS;
	}
	
	public String updateInput() throws Exception { 
		return SUCCESS;
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrtiption() {
		return descrtiption;
	}

	public void setDescrtiption(String descrtiption) {
		this.descrtiption = descrtiption;
	}

	
	
}
