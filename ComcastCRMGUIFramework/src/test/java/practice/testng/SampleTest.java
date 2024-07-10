package practice.testng;

import org.testng.annotations.Test;

public class SampleTest 
{
	@Test(invocationCount = 10)
	public void test1()
	{
		System.out.println("execute test");
	}
	@Test(enabled=false)// not mentioned this method treated as common method it will not excute
	public void createContactTest()
	{
		System.out.println("execute test");
	}
	@Test
	public void createContactwithphonenumberTest()
	{
		System.out.println("execute test");
		
	}

}
