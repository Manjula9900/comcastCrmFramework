package com.comcast.crm.objectrepositoryUtlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
/**
 * @author Manjula
 * Conatins login page elements and business lib like login
 */
public class LoginPage extends WebDriverUtility//Rule-1 create a separate java class
{
	WebDriver driver;
	public LoginPage(WebDriver driver)  //Rule3:Object Initialization 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	  @FindBy(name="user_name") //Rule-2 Object creation
	   private WebElement usernameEdt;
	   
	  @FindBy(name="user_password")
	   private WebElement passwordEdt;
	   
	  @FindBy(id="submitButton")
	   private WebElement loginBtn;
	  
	  /**
	   * login to application based on username, password, url arguments
	   * @param url
	   * @param username
	   * @param password
	   */
	  public void validLogin(String url,String username, String password) //Rule4: Object Encapsulation
	  {
		  waitForPageToLoad(driver);
		  driver.get(url);
		  usernameEdt.sendKeys(username);   
		  passwordEdt.sendKeys(password);
		  loginBtn.click();
		  //Rule5: Object Utilization
	  }
	

}
