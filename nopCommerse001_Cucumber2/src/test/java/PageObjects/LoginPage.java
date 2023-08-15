package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;

	public LoginPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	private WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	private WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	private WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	private WebElement lnkLogout;
	
	
	public void  setUsername(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void  setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	
	public void clickOnLogout()
	{
		lnkLogout.click();
	}
	
}
