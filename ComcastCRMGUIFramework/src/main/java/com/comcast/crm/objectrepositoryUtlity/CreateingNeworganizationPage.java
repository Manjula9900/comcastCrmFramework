package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateingNeworganizationPage 
{
	WebDriver driver;
	public CreateingNeworganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;
	@FindBy(name="industry")
	private WebElement industryrdd;
	@FindBy(name="accounttype")
	private WebElement typedd;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createOrg(String orgName)
	{
		 orgNameEdt.sendKeys(orgName);
		 saveBtn.click();
	}

	
	public void createOrg(String orgName, String induestry, String type)
	{
		 orgNameEdt.sendKeys(orgName);
		 Select sel = new Select(industryrdd);
		 sel.selectByVisibleText(induestry);
		 Select sel1 = new Select(typedd);
		 sel1.selectByVisibleText(type);
		 saveBtn.click();
	}
	
	
	
}
