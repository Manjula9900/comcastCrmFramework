package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtlity;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateContactWithSupporDateTest 
{
	public static void main(String[] args) throws IOException 
	{
		FileUtility flib= new FileUtility();
		JavaUtlity jlib = new JavaUtlity();
		WebDriverUtility wlib= new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		  
		  
		  //step3:read the value using getProperty("Key"}
		  String BROWSER =flib.getDataFromPropertyFile("browser");
		  String URL  =   flib.getDataFromPropertyFile("url");
		  String USERNAME =flib.getDataFromPropertyFile("username");
		  String PASSWORD = flib.getDataFromPropertyFile("password");	
		  //read testcript data from execel  
		 String lastName= elib.getDataFromExcel("contact",4,2)+jlib.getRandomNumber();
		 
		 // polymorphism pgm
		  WebDriver driver = null;
		  if(BROWSER.equals("chrome"))
		  {
			  driver= new ChromeDriver();
		  }else if(BROWSER.equals("firefox"))
		  {
			  driver=new FirefoxDriver();
		  }else {
			  driver= new ChromeDriver();
		  }
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  //navigate to org module
		  driver.findElement(By.linkText("Contacts")).click();
		  //click on create org button
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  
			//date format what we want
		   String  startdate= jlib.getSytemDateYYYYDDMM();
		   String endDate= jlib.getRequiredDateYYYYDDMM(30);
		   System.out.println(startdate);
			System.out.println(endDate);
		  //enter all the details and create new organization
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.name("support_start_date")).clear();
		  driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		  driver.findElement(By.name("support_end_date")).clear();
		  driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		  
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  //verify Header msg Expected result
		  String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		  if(actStartDate.equals(startdate))
		  {
			  System.out.println(startdate+"is verified ==PASS");
		  }
		  else
		  {
			  
			  System.out.println(startdate+"is not verified  ==Fail");
		  }
		  String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		  if(actEndDate.equals(endDate))
		  {
			  System.out.println(endDate+"is verified ==PASS");
		  }
		  else
		  {
			  
			  System.out.println(endDate+"is not verified ==Fail");
		  }
		  driver.quit();
		
	}


}
