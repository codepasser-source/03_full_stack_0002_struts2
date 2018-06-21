package com.baishui.bbs.util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class ConnectionFactory {

	 private static final ConnectionFactory conFactory  = new ConnectionFactory();
	 private static Connection conn; 
	 public ConnectionFactory() {
		  try {
	        	Context context =new  InitialContext(); 
	        	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/bbs"); 
	            conn = ds.getConnection();
	            System.out.println("----------DataBase Connection Success------------------------------");
	        } catch (Exception ex) {
	             
	           ex.printStackTrace();
	        } 
	 }
	 
	 public static  Connection getConnection(){ 
	             return conn;
	    }
	   
	   
	
}
