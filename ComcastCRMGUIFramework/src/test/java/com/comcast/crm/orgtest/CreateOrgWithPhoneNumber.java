package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateOrgWithPhoneNumber 
{
	
 public static void main(String[] args) throws IOException 
 {
	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
    String  BROWSER=flib.getDataFromPropertyFile("browser");
                      
 }

}
