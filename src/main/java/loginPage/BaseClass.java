package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass
{
	public WebDriver driver;
	
	public void OpenBrowser() throws InterruptedException 
	{
		driver=new FirefoxDriver();
		driver.get("https://dev-dash.janitri.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}

}
