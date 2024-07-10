package practice.testng;

import org.testng.annotations.Test;

public class OrderTestDependsonMethod 
{
	/*
	 * @Test public void createOrderTest() {
	 * System.out.println("execute createordertest");
	 * 
	 * }
	 * 
	 * @Test(dependsOnMethods="createOrderTest") public void billingOrderTest() {
	 * System.out.println("execute createordertest"); }
	 */
	
	@Test
	public void createOrderTest()
	{
		System.out.println("execute createordertest==>123");
		String str=null;
		System.out.println(str.equals("123"));
		
	}
	@Test(dependsOnMethods="createOrderTest")
	public void billingOrderTest()
	{
		System.out.println("execute billingordertest==>");
	}
}
