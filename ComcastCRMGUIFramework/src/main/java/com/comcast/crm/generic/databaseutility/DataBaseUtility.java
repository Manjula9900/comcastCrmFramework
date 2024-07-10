package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection con;
	public void getDbConnection(String url, String username, String password) throws SQLException
	{
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		 con = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			
		}
	}
	public void getConnection() throws SQLException
	{
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectsdb", "root", "root");
		}catch (Exception e) {
			
		}
	}
	public void closeDbConnection() throws SQLException
	{
		con.close();
	}
	public ResultSet excecuteSelectQuery(String query) throws SQLException
	{
	    ResultSet result=null;
		try {
		Statement stat = con.createStatement();
	     result = stat.executeQuery(query);
		}catch (Exception e) {
			
		}
		return result;
	}
	public int excecutenonSelectQuery(String query) throws SQLException
	{
	    int result=0;
		try {
		Statement stat = con.createStatement();
	     result = stat.executeUpdate(query);
		}catch (Exception e) {
			
		}
		return result;
	}

}
