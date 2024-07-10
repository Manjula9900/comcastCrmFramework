package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDP 
{
	@Test(dataProvider = "getData")
	public void createContac(String Fn, String Ln, long phonenumber)
	{
		System.out.println("FirstName"+Fn+"LastName"+Ln+"phnnumber"+phonenumber);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[3][3];
		objArr[0][0]="Deepak";
		objArr[0][1]="HR";
		objArr[0][2]=8956826358L;
		objArr[1][0]="Roop";
		objArr[1][1]="HD";
		objArr[1][2]=9865234562L;
		objArr[2][0]="Papa";
		objArr[2][1]="HP";
		objArr[2][2]=9756123456L;
		return objArr;
	}

}
