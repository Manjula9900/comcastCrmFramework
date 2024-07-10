package com.comcast.crm.orgtest;

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
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtlity.CreateingNeworganizationPage;
import com.comcast.crm.objectrepositoryUtlity.HomePage;
import com.comcast.crm.objectrepositoryUtlity.LoginPage;
import com.comcast.crm.objectrepositoryUtlity.OraganizationinfoPage;
import com.comcast.crm.objectrepositoryUtlity.OrganizationPage;
import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

public class CreateOrganizationTest 
{
public static void main(String[] args) throws IOException 
{
	 FileUtility flib = new FileUtility();
	 JavaUtlity jlib= new JavaUtlity();
	 ExcelUtility elib =new ExcelUtility();
	 WebDriverUtility wlib = new WebDriverUtility();
  
	  //step3:read the value using getProperty("Key"}
	  String BROWSER =flib.getDataFromPropertyFile("browser");
	  String URL  =   flib.getDataFromPropertyFile("url");
	  String USERNAME =flib.getDataFromPropertyFile("username");
	  String PASSWORD = flib.getDataFromPropertyFile("password");
	  //random num generation
	          
	  //read testcript data from execel  
	  
	  String orgName = elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
	  
	  
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
	  LoginPage l = new LoginPage(driver);
	  l.validLogin(USERNAME, PASSWORD, URL);
	  
	  //navigate to Organization module
	  HomePage h = new HomePage(driver);
	  h.getOrgLink().click();
	 
	  OrganizationPage oc= new OrganizationPage(driver);
	  oc.getCreatenewOrgButton().click();
	  
	  //Create Organization 
	  CreateingNeworganizationPage cnop= new CreateingNeworganizationPage(driver);
	  cnop.createOrg(orgName);
	  //verify Header msg Expected result
	  OraganizationinfoPage  opo= new OraganizationinfoPage(driver);
	 String  actOrgName= opo.getHeaderMsg().getText();
	//verify header orgname info Expected result
	  if(actOrgName.contains(orgName))
	  {
		  System.out.println(orgName+"is verified ==PASS");
	  }
	  else
	  {
		  System.out.println(orgName+"is not created ==Fail");
	  }
	  
	 //logout
	  h.logout();
	  
	  driver.quit();
	
}

}
