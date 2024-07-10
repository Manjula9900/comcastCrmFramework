package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateclasswithDataprovider 
{
	@Test(dataProvider = "getData")
	public void createContac(String Fn, String Ln)
	{
		System.out.println("FirstName"+Fn+"LastName"+Ln);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="Deepak";
		objArr[0][1]="HR";
		objArr[1][0]="Roop";
		objArr[1][1]="HD";
		objArr[2][0]="Papa";
		objArr[2][1]="HP";
		return objArr;
	}

}
