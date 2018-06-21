package com.baishui.bbs.util;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public abstract class BbsDao {

	public Connection conn;

	public BbsDao() {
		 conn = ConnectionFactory.getConnection();
	}
	
	
	  public abstract Collection<Object> query(Object model) throws DaoException,SQLException;

	    public abstract String insert(Object model) throws DaoException,SQLException;

	    public abstract String update(Object model) throws DaoException,SQLException;

	    public abstract String delete(Object model) throws DaoException,SQLException;

	    public abstract Object findByPrimaryKey(String id) throws DaoException,SQLException;

	    public void rollback(Connection connection) throws DaoException ,SQLException{
	        try {
	            connection.rollback();
	        } catch (SQLException e) {
	            throw new DaoException("回滚异常:" + e);

	        }
	    }

	    public void closeResultSet(ResultSet resultSet) throws DaoException,SQLException {
	        try {
	        	 
	            resultSet.close();
	            resultSet = null;
	            System.out.println("resultSet Close...");
	        } catch (SQLException e) {
	            throw new DaoException("resultSet Close Exception...：" + e);

	        }

	    }

	    public void closeStatement(Statement statement) throws DaoException ,SQLException{
	        try {
	            statement.close();
	            statement = null;
	            System.out.println("Statement Close...");
	        } catch (SQLException e) {
	            throw new DaoException("Statement Close:" + e);
	        }

	    }

	    public void closeConnection(Connection connection) throws DaoException,SQLException {
	        try {
	        	if(!connection.isClosed()){ 
	        		connection.close();
	        		System.out.println("--------DataBase Connection Close---------------------");
	        	}
	            
	        } catch (SQLException e) {
	            throw new DaoException("DataBase Connection Exception..." + e);
	        }

	    }

	    public String executeUpdate(Connection connection, String sql) throws DaoException,SQLException {
	        String msg = "n";
	        try {
	            Statement stat = connection.createStatement();
	            int i = stat.executeUpdate(sql);
	            if (i != 0) {
	                msg = "y";
	            }

	            closeStatement(stat);


	        } catch (SQLException e) {
	            throw new DaoException("指定：" + sql + "出现异常" + e);
	        }
	        return msg;
	    }
	    //ֵ

	    public static int getMaxid(Connection connection, String table, String col) throws DaoException ,SQLException{
	        String sql = "select max(" + col + ")from " + table;
	        int max = 0;
	        try {
	            Statement stat = connection.createStatement();
	            ResultSet rs = stat.executeQuery(sql);
	            if (rs.next()) {
	                max = rs.getInt(1);
	            }
	            rs.close();
	            stat.close();
	            connection.close();
	        } catch (SQLException e) {
	            throw new DaoException("" + e);
	        }
	        return max;
	    }
}
