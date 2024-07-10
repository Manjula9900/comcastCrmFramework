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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtlity;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtlity.CreateingNeworganizationPage;
import com.comcast.crm.objectrepositoryUtlity.HomePage;
import com.comcast.crm.objectrepositoryUtlity.LoginPage;
import com.comcast.crm.objectrepositoryUtlity.OraganizationinfoPage;
import com.comcast.crm.objectrepositoryUtlity.OrganizationPage;

public class CreateOrgnizationWithIndustry {
	public static void main(String[] args) throws IOException {
		FileUtility flib = new FileUtility();
		JavaUtlity jlib = new JavaUtlity();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		// step3:read the value using getProperty("Key"}
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");
		// random num generation
		Random r = new Random();
		int random = r.nextInt(10000);
		// read testcript data from execel
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String induestry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);
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
		// navigate to org module
		HomePage h = new HomePage(driver);
		h.getOrgLink().click();
		// click on create org button
		OrganizationPage oc = new OrganizationPage(driver);
		oc.getCreatenewOrgButton().click();
		// enter all the details and create new organization
		CreateingNeworganizationPage cnop = new CreateingNeworganizationPage(driver);
		cnop.createOrg(orgName, induestry, type);

		// verify the dropdown industries and type info
		OraganizationinfoPage oc1 = new OraganizationinfoPage(driver);
		String actualIndustries = oc1.getHeaderMsgindus().getText();
		if (actualIndustries.equals(induestry)) {
			System.out.println(induestry + "info is verified ==PASS");
		} else {
			System.out.println(induestry + " info is not verified==Fail");
		}
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actualType.equals(type)) {
			System.out.println(type + "info is verified ==PASS");
		} else {
			System.out.println(type + " info is not verified==Fail");
		}

		driver.quit();

	}

}
