package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener
{
    WebDriver driver;
    public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	public void onStart(ISuite suite) 
	{
	    String time = new Date().toString().replace(" ","_" ).replace(":", "_");
	 System.out.println("Report configuration");
	// spark report configuration
			spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("CRM Test suite Result");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			// add env info and create test
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows 11");
			report.setSystemInfo("BROWSER", "Chrome-100");
	 
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) 
	{
		//display name of the testcase in console
		System.out.println("===="+result.getMethod().getMethodName()+"====Start<====");
		//create testcase inside extent report, execute before every test
		test=report.createTest(result.getMethod().getMethodName());	
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED===>");
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"====END====");
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===>COMPLETED<===");
	}
	public void onTestFailure(ITestResult result) {
		
	    String testName = result.getMethod().getMethodName();
		TakesScreenshot tss = (TakesScreenshot)Baseclass.sdriver;
	    String filepath = tss.getScreenshotAs(OutputType.BASE64);
	    //testcase name should be the failed testcase name
	    String time = new Date().toString().replace(" ","_" ).replace(":", "_");
	    test.addScreenCaptureFromBase64String(filepath, testName+" "+time);
	    test.log(Status.FAIL, result.getMethod().getMethodName()+"===>failed<===");
	                      
	}
}
