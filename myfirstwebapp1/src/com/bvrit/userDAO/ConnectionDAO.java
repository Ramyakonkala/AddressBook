package com.bvrit.userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDAO {
	public  Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/addressbookdbs";//demo";
		String user = "root";
		String password = "123456";
		Connection conn = null;	      
		try {
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			//create connection
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("successfully connected"); 
		return conn;      
	}
}