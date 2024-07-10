package practicetest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ProductDPwithExcel 
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
	ExcelUtility elib= new ExcelUtility();

			
	//Starlight    Blue
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib= new ExcelUtility();
		 int rowcount = elib.getRowcount("products");
		 
		 Object[][] objArr= new Object[rowcount][2];
		 for(int i=0; i<rowcount; i++)
		 {
		 //first row and first clm
		 objArr[i][0]=elib.getDataFromExcel("products", i+1,0);
		 //first row and second clm
		 objArr[i][1]=elib.getDataFromExcel("products", i+1,1);
		 }
		 return objArr;
		 	
}

}


