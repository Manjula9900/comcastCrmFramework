package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactWithOrg 
{
	WebDriver driver;
	public CreateContactWithOrg (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement lstNameEdt;
	@FindBy(name = "account_name")
	private WebElement orgNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void getContNameEdt(String lastname, String orgname)
	{
		lstNameEdt.sendKeys(lastname);
		 orgNameEdt.sendKeys(orgname);
		 saveBtn.click();
	}
	

}
