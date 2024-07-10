package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CreateContactTestJava 
{
	public static void main(String[] args) throws IOException 
	{
		 FileUtility flib = new FileUtility(); 
		 ExcelUtility elib = new ExcelUtility();
		 JavaUtlity jlib = new JavaUtlity();
		  //step3:read the value using getProperty("Key"}
		  String BROWSER =flib.getDataFromPropertyFile("browser");
		  String URL  =flib.getDataFromPropertyFile("url");
		  String USERNAME =flib.getDataFromPropertyFile("username");
		  String PASSWORD = flib.getDataFromPropertyFile("password");
		  //random num generation
		 
		  //read testcript data from execel  
		 String lastName = elib.getDataFromExcel("contact",1,2)+jlib.getRandomNumber();;

	
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
		  //enter all the details and create new organization
		  driver.findElement(By.name("lastname")).sendKeys(lastName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  //verify Header msg Expected result
		  String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		  if(actLastName.equals(lastName))
		  {
			  System.out.println(lastName+"is created ==PASS");
		  }
		  else
		  {
			  
			  System.out.println(lastName+"is not created ==Fail");
		  }  
		  driver.quit();
		
	}

}
