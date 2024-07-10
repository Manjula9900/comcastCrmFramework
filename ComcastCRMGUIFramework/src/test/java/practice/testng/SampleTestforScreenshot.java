package practice.testng;

import java.io.File;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SampleTestforScreenshot 
{
	@Test
	public void amazonTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
	    TakesScreenshot tss = (TakesScreenshot)driver;
	     File src = tss.getScreenshotAs(OutputType.FILE);
	     File dst= new File("./test.png");
	     
	
		
	}

}
