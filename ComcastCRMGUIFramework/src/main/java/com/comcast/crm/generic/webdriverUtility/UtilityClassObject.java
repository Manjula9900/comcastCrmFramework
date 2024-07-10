package com.comcast.crm.generic.webdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{
	//used share the static variables
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ExtentTest getTest()
	{
		return test.get();
	}
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver)
	{
	   driver.set(actDriver);
	}

}
