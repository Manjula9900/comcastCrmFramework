package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

public class CreateContactWithOrgTest 
{
	public static void main(String[] args) throws IOException 
	{
	     FileUtility flib = new FileUtility();
	     ExcelUtility elib = new ExcelUtility();
	     JavaUtlity jlib= new JavaUtlity();
	     WebDriverUtility wlib = new WebDriverUtility();
		  
		  //step3:read the value using getProperty("Key"}
		  String BROWSER =flib.getDataFromPropertyFile("browser");
		  String URL  =   flib.getDataFromPropertyFile("url");
		  String USERNAME =flib.getDataFromPropertyFile("username");
		  String PASSWORD = flib.getDataFromPropertyFile("password");
		  //random num generation 
		  //read testcript data from execel  

		  String orgName  = elib.getDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();
		  String ContactName  = elib.getDataFromExcel("contact", 7, 3);
		  
		
		  //polymorphism pgm
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
		  wlib.waitForPageToLoad(driver);
		  driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  //navigate to org module
		  driver.findElement(By.linkText("Organizations")).click();
		  //click on create org button
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  //enter all the details and create new organization
		  driver.findElement(By.name("accountname")).sendKeys(orgName);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  //verify Header msg Expected result
		  String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(headerinfo.contains(orgName))
		  {
			  System.out.println(orgName+"is created ==PASS");
		  }
		  else
		  {
			  System.out.println(orgName+"is not created ==Fail");
		  }
		  //Step5:navigate to contact module
		  driver.findElement(By.linkText("Contacts")).click();
		  // step6: click on create org button
		  driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		  //enter all the details and create new organization
		  driver.findElement(By.name("lastname")).sendKeys(ContactName);
		  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		  //switch to child window
		  wlib.switchToTabOnURL(driver, "module=Accounts");
		  driver.findElement(By.name("search_text")).sendKeys(orgName);
		  driver.findElement(By.name("search")).click();
		  //converting runtime xpath to static
		  driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		  //switch to parent window
		  wlib.switchToTabOnURL(driver, "module=Contacts&action");
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify Header msg Expected result
		   headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(headerinfo.contains(ContactName))
		  {
			  System.out.println(ContactName+"is created ==PASS");
		  }
		  else
		  {
			  System.out.println(ContactName+"is not created ==Fail");
		  }
		   String actOrgName= driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actOrgName); 
		   if( actOrgName.trim().equals(orgName))
			  {
				  System.out.println(orgName+"is created ==PASS");
			  }
			  else
			  {
				  System.out.println(orgName+"is not created ==Fail");
			  }
		   driver.quit();
		

}
}
