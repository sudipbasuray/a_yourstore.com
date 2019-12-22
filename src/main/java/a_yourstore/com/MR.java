package a_yourstore.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MR 
{

	static WebDriver driver;
	
	public void BrowserLanuch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe" );
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(3000);
	}
	
	public void BrowserClose()
	{
		driver.close();
	}
	
	public void AppLogin(String username,String password) throws InterruptedException
	{
		WebElement uname =driver.findElement(By.xpath("//input[@class='email']"));
		uname.sendKeys(username);
		Thread.sleep(3000);
		WebElement pswrd=driver.findElement(By.xpath("//input[@class='password']"));
		pswrd.sendKeys(password);
		Thread.sleep(3000);
		WebElement login =driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		login.click();
		Thread.sleep(3000);
	}
	
	public boolean VerifyLogin()
	{
		String acturl =driver.getCurrentUrl();
		String expurl="https://admin-demo.nopcommerce.com/admin/";
		
		if(acturl==expurl)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
