package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage 
{
	WebDriver driver;
	public ContactinfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='[ CON355 ] hhhjj  -  Contact Information']")
     private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

}
