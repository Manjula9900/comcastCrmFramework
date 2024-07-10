package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;

public class Baseclass 
{
	DataBaseUtility dlib= new DataBaseUtility();
	@BeforeSuite
	public void configBS()
	{
		
		System.out.println("===connect to database===, Report config");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("===launch browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("===login to application");
	}
	@AfterMethod
	public void confiAm()
	{
		System.out.println("===logout from application===");
	}
	@AfterClass
	public void ConfigAC()
	{
		System.out.println("===close the browser===");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("===close db, Report backup");
	}
	
	
}
	



