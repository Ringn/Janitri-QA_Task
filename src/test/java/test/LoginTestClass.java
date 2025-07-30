package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginPage.BaseClass;
import loginPage.Login;



public class LoginTestClass extends BaseClass
{
	Login login;

	@BeforeMethod
	public void OpenBrowserforLogin() throws InterruptedException 
	{
		
		 OpenBrowser();
		 login=new Login(driver);
	   
	}
	@Test
	public void login_with_blank_fields() throws InterruptedException 
	{
		login.testLoginButtonDisabledWhenFieldAreEmpty();
		
		System.out.println(login.testInvalidLoginShowErrorMsg("",""));
		
		
	}
	@Test
	public void login_with_Random_Number() throws InterruptedException 
	{
		
		System.out.println(login.testInvalidLoginShowErrorMsg("abc","def"));
		
	}
	@Test
	public void Password_Masking_Unmasking() throws InterruptedException 
	{
		
		login.testPasswordMaskedbutton("123");
		
	}
	@Test
	public void ValidatePresenceOfPageObject() throws InterruptedException 
	{
		login.Elements();
		
		
		
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException 
	{
		driver.close();
	   
	}
	
	
	
	

}
