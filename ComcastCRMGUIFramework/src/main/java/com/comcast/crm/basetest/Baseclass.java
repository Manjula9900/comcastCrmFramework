package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtlity;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtlity.HomePage;
import com.comcast.crm.objectrepositoryUtlity.LoginPage;

import lombok.experimental.UtilityClass;

public class Baseclass {
	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtlity jlib = new JavaUtlity();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	

	@BeforeSuite(groups = { "smoke", "regression" })
	public void configBS() throws SQLException {
		dlib.getConnection();
		System.out.println("===connect to database===, Report config");
		
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smoke", "regression" })
	public void configBC(@Optional("chrome") String browser) throws IOException {
		System.out.println("===launch browser");
		// String BROWSER = flib.getDataFromPropertyFile("browser");
		String BROWSER = browser;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void configBM() throws IOException {
		System.out.println("===login to application");
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");
		LoginPage l = new LoginPage(driver);
		l.validLogin(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void confiAm() {
		System.out.println("===logout from application===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void ConfigAC() throws SQLException {
		driver.close();
		System.out.println("===close the browser===");
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void configAS() throws SQLException {
		dlib.closeDbConnection();
		System.out.println("===close db, Report backup");
	
	}

}
