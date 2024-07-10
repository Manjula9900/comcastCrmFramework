package practicetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass;

public class InvoiceTest1 
{
	public class InvoiceTest extends Baseclass
	{
		@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImp.class)
		public void createInvoiceTest()
		{
		System.out.println("execute createinvoiceTest");	
		 String actTitle = driver.getTitle();
		 Assert.assertEquals(actTitle, "login");
		 System.out.println("step1");
		 System.out.println("step2");
		 System.out.println("step3");
		 System.out.println("step4");
		}

}
}
