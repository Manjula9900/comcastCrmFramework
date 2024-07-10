package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewcontactPage 
{
	WebDriver driver;
	public CreateNewcontactPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement lstNameEdt;
	@FindBy(id="assistantphone")
	private WebElement phonenumber;
	@FindBy(name="support_start_date")
	private WebElement startDate;
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public void CreateContact(String lastName, String phoneNum) 
	{
		lstNameEdt.sendKeys(lastName);
		phonenumber.sendKeys(phoneNum);		 
		 saveBtn.click();
	}
	
	public void CreateContact(String lastName, String Startdate, String ENddate) 
	{
		lstNameEdt.sendKeys(lastName);
		
		 startDate.sendKeys(Startdate);
		 endDate.sendKeys(ENddate);
		 saveBtn.click();
	}




}
