package practicetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class GetProductInfoTest 
{
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.Flipkart.com/");
		//search product
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
		//capture product info
		String x = "//div[text()='"+productName+"']/../../div[2]/div[1]/div[1]/div[1]";
	    String price=driver.findElement(By.xpath(x)).getText();
	    System.out.println(price);
        	
	}
	//Starlight    Blue
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 14 Plus (Midnight, 128 GB)";
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 14 Plus (Starlight, 128 GB)";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 14 Plus (Blue, 128 GB)";

		return objArr;
	
	

}
}
