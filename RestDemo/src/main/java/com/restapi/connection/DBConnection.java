package com.restapi.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	
	public static Connection getMySQLConnection(){
		
		Properties props = new Properties();
		FileInputStream fs = null;
		Connection con = null;
		
		try {
//			System.out.println(new File(".").getAbsolutePath());
			fs = new FileInputStream("dbconnection.properties");
			props.load(fs);
			String url = props.getProperty("mysql.connection.url");
			String username = props.getProperty("mysql.connection.username");
			String password = props.getProperty("mysql.connection.password");
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
