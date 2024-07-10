package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

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

public class DeleteOrgTest {
    	public static void main(String[] args) throws IOException {
		FileUtility flib = new FileUtility();
		JavaUtlity jlib = new JavaUtlity();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		// step3:read the value using getProperty("Key"}
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL =      flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");
		// read testcript data from execel

		String orgName = elib.getDataFromExcel("org", 10, 2) + jlib.getRandomNumber();

		// polymorphism pgm
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		LoginPage l = new LoginPage(driver);
		l.validLogin(USERNAME, PASSWORD, URL);
		// navigate to Organization module
		HomePage h = new HomePage(driver);
		h.getOrgLink().click();
		OrganizationPage oc = new OrganizationPage(driver);
		oc.getCreatenewOrgButton().click();
		// Create Organization
		CreateingNeworganizationPage cnop = new CreateingNeworganizationPage(driver);
		cnop.createOrg(orgName);	
		// go back to Organizations Page
		h.getOrgLink().click();
		// search for organization
		oc.getSearchEdt().sendKeys(orgName);
		wlib.select(oc.getSearchdd(), "Organization Name");
		oc.getSearchbtn().click();
		// "+OrgName+" to get the unique elemet
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		wlib.switchtoAlertAndAccept(driver);
		// In dynamic webtable select and delete org

		// logout
		h.logout();

		driver.quit();

	}
}
