package com.creatio.hrm.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

public class DBUtil {
	
	public static Properties prop = PropUtil.readData("Config.properties");
	
	// Common method to connect with database and get the raw data from the database tables.
	public static ResultSet executeQuery(String query)  {
		ResultSet dataSet = null;
		String dbUrl = prop.getProperty("db.url");
		String dbUserName = prop.getProperty("db.username");
		String dbPassword = prop.getProperty("db.password");	
		try {
			Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);// connect to database
			dataSet = connection.createStatement().executeQuery(query);// execute query and get raw data
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSet;
	}


}
