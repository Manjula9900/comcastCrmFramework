package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createnewbutton;
	public WebElement getCreatenewbutton() {
		return createnewbutton;
	}
	

}
