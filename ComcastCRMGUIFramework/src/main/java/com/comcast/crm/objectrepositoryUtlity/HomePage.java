package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText = "Campaigns")
	private WebElement Campaignlnk;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	@FindBy(linkText = "Products")
	private WebElement productslink;

	public WebElement getProductslink() {
		return productslink;
	}

	public void setProductslink(WebElement productslink) {
		this.productslink = productslink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void navigateToCompaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		Campaignlnk.click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutlink.click();

	}

}
