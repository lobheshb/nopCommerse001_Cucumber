package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import ch.qos.logback.classic.Logger;

public class BaseClass
{
	private WebDriver driver;
	 public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchcust;
//	public static Logger logger;
	public Properties configProp;
	
	//Created for generating random string for unique mail
	public static String randomstring()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
	
	
	
	
}
