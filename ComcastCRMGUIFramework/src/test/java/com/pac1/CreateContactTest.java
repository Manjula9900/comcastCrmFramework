package com.pac1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest 
{
	@BeforeSuite
	public void configBS()
	{
		System.out.println("bs");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("as");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("bc");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("bm");
	}
	@Test
	public void createContact()
	{
		System.out.println("cc");
	}
	@Test
	public void createContactssd()
	{
		System.out.println("cc");
	}
	@AfterMethod
	public void confiAm()
	{
		System.out.println("am");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("ac");
	}
	

}
