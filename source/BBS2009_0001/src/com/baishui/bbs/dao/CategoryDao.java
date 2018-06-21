package com.baishui.bbs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
 

import com.baishui.bbs.model.Category;
import com.baishui.bbs.util.BbsDao;
import com.baishui.bbs.util.DaoException;

public class CategoryDao extends BbsDao { 
	
	private static final  CategoryDao cateDao = new CategoryDao();
	
	public static CategoryDao getInstance(){
		return cateDao; 
	}
	

	 public Collection<Category> list() throws DaoException, SQLException{
		 
		String sql = "select * from category"; 
		PreparedStatement ps =  this.conn.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		 
		Collection<Category> categories = new ArrayList<Category>();
		while(rs.next()){
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setDescrtiption(rs.getString(3)); 
			categories.add(category); 
		}
		
		 closeResultSet(rs);
		 closeStatement(ps);
		
		 return categories;
		 
	 }

	@Override
	public String delete(Object model) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findByPrimaryKey(String id) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(Object model) throws DaoException, SQLException {
		
		String msg = "fail";
		
		Category category = (Category)model; 
		String sql="insert into category(name,descrtiption)" +
				"values(?,?)";
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, category.getName());
		ps.setString(2, category.getDescrtiption());
		int i = ps.executeUpdate();
		if(i==1){
			System.out.println("category add success");			
			msg = "success";
		}else{ 
			System.out.println("category add fail");
		}
		closeStatement(ps);
		
		return msg;
	}

	@Override
	public Collection<Object> query(Object model) throws DaoException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object model) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
