package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationinfoPage 
{
	WebDriver driver;
	public OraganizationinfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	@FindBy(id="dtlview_Industry")
    private WebElement headerMsgindus;
	
	public WebElement getHeaderMsgindus() {
		return headerMsgindus;
	}
	
	
 
}
