package practicetest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.*;




//@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class InvoiceTest extends Baseclass
{
	@Test
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
	@Test
	public void createInvoicewithContcatTest()
	{
		System.out.println("execute createinvoicewithContactTest");	
		 System.out.println("step1");
		 System.out.println("step2");
		 System.out.println("step3");
		 System.out.println("step4");
	}

}
