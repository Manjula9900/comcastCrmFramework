package practice.testng;

import org.testng.annotations.Test;

public class PriorityDrawbackandSln 
{
	@Test(priority =-1)
	public void createContact()
	{
		System.out.println("execute createcontact test");
	}
	@Test(priority=0)
	public void modifyContact()
	{
		System.out.println("execute query insert contact in DB==>ICICI");
		System.out.println("execute modifycontact test");
	}
	@Test(priority=3)
	public void deleteContact()
	{
		System.out.println("execute query insert contact in DB==>UPI");
		System.out.println("execute deletecontact test");
	}

}
