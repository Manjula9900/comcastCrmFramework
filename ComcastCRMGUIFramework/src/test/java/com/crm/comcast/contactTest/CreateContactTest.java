package com.crm.comcast.contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryUtlity.ContactPage;
import com.comcast.crm.objectrepositoryUtlity.ContactinfoPage;
import com.comcast.crm.objectrepositoryUtlity.CreateContactWithOrg;
import com.comcast.crm.objectrepositoryUtlity.CreateNewcontactPage;
import com.comcast.crm.objectrepositoryUtlity.CreateingNeworganizationPage;
import com.comcast.crm.objectrepositoryUtlity.HomePage;
import com.comcast.crm.objectrepositoryUtlity.OrganizationPage;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.*;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtlity;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListImpClass;

public class CreateContactTest extends Baseclass {
	@Test(groups = "smoke")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		System.out.println("execute createOrgTest and verify");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read testscript data from excel
		String lastName = elib.getDataFromExcel("contact", 1, 2);
		String PhoneNo = elib.getDataFromExcel("contact", 1, 3);
		// step2 :navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact module");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO, "click on create contact Button");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewContactButton().click();
		// step4: enter all the details and create a new contact
		UtilityClassObject.getTest().log(Status.INFO, " enter all the details and create a new contact");
		CreateNewcontactPage c = new CreateNewcontactPage(driver);
		UtilityClassObject.getTest().log(Status.PASS, "Created");
		c.CreateContact(lastName, PhoneNo);
		// verfify header phonenumber info Expected result

		String actphone = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actphone.equals(lastName)) {
			System.out.println(lastName + "verified");
		} else {
			System.out.println(lastName + " not verified");
		}

	}

	@Test(groups = "regression")
	public void createContactWithDateTest() throws EncryptedDocumentException, IOException {
		String lastName = elib.getDataFromExcel("contact", 1, 2);
		// step2 :navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// step3: click on create contact Button
		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewContactButton().click();
		// step4: enter all the details and create a new contact
		CreateNewcontactPage c = new CreateNewcontactPage(driver);
		String SD = jlib.getSytemDateYYYYDDMM();
		String ED = jlib.getRequiredDateYYYYDDMM(30);
		c.CreateContact(lastName, SD, ED);
		// verfify header phonenumber info Expected result
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(SD)) {
			System.out.println(SD + "verified");
		} else {
			System.out.println(SD + "not verified");
		}
		if (actEndDate.equals(ED)) {
			System.out.println(ED + "verified");
		} else {
			System.out.println(ED + "not verified");
		}
	}

	@Test(groups = "regression")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		// read testscript data from excel file
		String orgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String ContactName = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		// Step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step3: click on create new organization Button
		OrganizationPage o = new OrganizationPage(driver);
		o.getCreatenewOrgButton().click();;
		// step4: enter all the details and create new organization
		CreateingNeworganizationPage oc = new CreateingNeworganizationPage(driver);
		oc.createOrg(orgName);
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "is created ==PASS");
		} else {
			System.out.println(orgName + "is not created ==Fail");
		}
		//step5: navigate to contact module
		hp.getContactLink().click();
		//step6: click on create contact button
		ContactPage cp = new ContactPage(driver);
		cp.getCreatenewContactButton().click();
		//step7: enter all the details and create new contact
		CreateContactWithOrg  cpp= new CreateContactWithOrg(driver);
		cpp.getContNameEdt(ContactName, orgName);
		String actlOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if (actlOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "is created ==PASS");
		} else {
			System.out.println(orgName + "is not created ==Fail");
		}
		
		
	}
}