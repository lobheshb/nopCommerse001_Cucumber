package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper
{
	public WebDriver driver;

	public waitHelper(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void waitElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
