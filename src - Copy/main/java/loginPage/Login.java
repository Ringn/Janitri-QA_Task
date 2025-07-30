package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login 
{
	
	@FindBy(xpath="//input[@id='formEmail']")private WebElement UserId;
	@FindBy(xpath="//input[@id='formPassword']")private WebElement Password;
	@FindBy(xpath="//button[@class='login-button']")private WebElement LoginButton;
	@FindBy(xpath="//img[@class='passowrd-visible']")private WebElement PassWordEyeIcon;
	@FindBy(xpath="//p[@class='normal-text']")private WebElement ErrorMsg;
	@FindBy(xpath="//p[@class='sub-title']")private WebElement Title;


	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void testLoginButtonDisabledWhenFieldAreEmpty() throws InterruptedException
	{
		Thread.sleep(4000);
		boolean result = LoginButton.isEnabled();
		if(result==false)
		{
			System.out.println("login button is disabled");
		}
		else
		{
			System.out.println("Fail:=login button is enabled");
		}
	}
	
	public void testPasswordMaskedbutton(String pass) throws InterruptedException
	{
		 Password.sendKeys(pass);
		 String val1 = Password.getAttribute("type");
		 System.out.println(val1);
		 Thread.sleep(2000);
		 PassWordEyeIcon.click();
		 Thread.sleep(4000);
		 String val2 = Password.getAttribute("type");
		 System.out.println(val2);

		 if (val1.equals("password") && val2.equals("text")) 
		 {
		     System.out.println("PASS: Eye icon reveals password.");
		 }
		 else 
		 {
		     System.out.println("FAIL: Eye icon does not reveal password.");
		 }
		
		
	}
	public String testInvalidLoginShowErrorMsg(String UI,String pass) throws InterruptedException
	{ 
		Thread.sleep(2000);
	    UserId.sendKeys(UI);
	    Thread.sleep(2000);
	    Password.sendKeys(pass);

	    LoginButton.click();
	    Thread.sleep(4000);
	    String text = ErrorMsg.getText();
	    return text;
	}
	
	public void Elements() throws InterruptedException 
	{
		Thread.sleep(2000);
		boolean result = Title.isDisplayed();
		 
		System.out.println("TitleDisplay:"+Title.isDisplayed());
		if(result==true)
		{   
			String title = Title.getText();
			System.out.println(title);
		}
		
		System.out.println("-----------------");
		
		System.out.println("UserIDDisplay:"+UserId.isDisplayed());
		System.out.println("PasswordDisplay:"+Password.isDisplayed());
		System.out.println("EyeIconDisplay:"+PassWordEyeIcon.isDisplayed());
		
		
		
		
		
	}

}
