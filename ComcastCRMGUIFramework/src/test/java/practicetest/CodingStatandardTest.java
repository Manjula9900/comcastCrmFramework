package practicetest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.Baseclass;
import com.comcast.crm.objectrepositoryUtlity.LoginPage;

/**
 * test class for Contact module
 * @author Manjula
 */
public class CodingStatandardTest extends Baseclass
{
	@Test
	public void searchcontactTest()
	{
		LoginPage lp = new LoginPage(driver);
		lp.validLogin("url","username", "password");
	}

}
