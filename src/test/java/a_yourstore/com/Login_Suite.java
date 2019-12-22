package a_yourstore.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Suite 
{

	WebDriver driver;
	MR mr=new MR();
	@BeforeMethod
	public void browserlaunch() throws InterruptedException
	{
		mr.BrowserLanuch();
	}
	@Test(priority=0)
	public void verifylogin()
	{
		try {
		mr.AppLogin("admin@yourstore.com", "admin");
		Assert.assertEquals(false, mr.VerifyLogin());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	@Test(priority=1)
	public void verifyinvalidlogin()
	{
		try {
			mr.AppLogin("asdsad", "asdasdxz");
			Assert.assertEquals(false, mr.VerifyLogin());
			System.out.println("Login Successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("login unsuccesful");
		}
	}
	@AfterMethod
	public void appclose()
	{
		mr.BrowserClose();
	}
}
