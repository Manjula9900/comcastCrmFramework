package practice.homepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageVerification 
{

	@Test
	
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" test start");
		String expectedPage="Home page";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle=driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
	    Assert.assertEquals(actTitle, expectedPage);
		driver.close();
		System.out.println(mtd.getName()+" test end");
	}

	@Test
	public void VerifyLogohomePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" test start");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(status);
		driver.close();
		System.out.println(mtd.getName()+" test end");
	}

}
