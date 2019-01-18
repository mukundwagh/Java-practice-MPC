package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

//Override and implement all the methods of DBConnectionUtil here to create and close db connection 
public class DatabaseConnectionManager implements DBConnectionUtil {

	Connection conn;
Statement	st;
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql://localhost/libdb","root","root");
	 
		return conn;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		conn.close();
	}

}
