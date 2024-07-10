package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver;
	public OrganizationPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
 private WebElement createnewOrgButton;
 @FindBy(name="search_text")
 private WebElement searchEdt;
 @FindBy(name="search_field")
 private WebElement searchdd;
 @FindBy(name="submit")
 private WebElement searchbtn;
 public WebElement getSearchbtn() {
	return searchbtn;
}

 
 public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchdd() {
	return searchdd;
}


public WebElement getCreatenewOrgButton() {
	return createnewOrgButton;
}

}
