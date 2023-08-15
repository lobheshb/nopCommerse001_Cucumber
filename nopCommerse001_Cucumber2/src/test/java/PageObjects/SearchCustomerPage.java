package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class SearchCustomerPage 
{
	public WebDriver ldriver;
	waitHelper waithelper1;
	
	public SearchCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(ldriver, this);
		waithelper1=new waitHelper(ldriver);
	}
	
	
	By Email = By.xpath("//input[@id='SearchEmail']");

	By FirstName = By.xpath("//input[@id='SearchFirstName']");

	By LastName = By.xpath("//input[@id='SearchLastName']");
	
	By Search = By.xpath("//button[@id='search-customers']");
	
	By table = By.xpath("//div[@id='customers-grid_wrapper']//tr//td[2]");
	
	By tableRow = By.xpath("//div[@id='customers-grid_wrapper']//tr");
	
	By tableColumn = By.xpath("//div[@id='customers-grid_wrapper']//tr//td");
	
	public void setEmail(String email)
	{	
		WebElement email1 = ldriver.findElement(Email);
		waithelper1.waitElement(email1);
		email1.clear();
		email1.sendKeys(email);
	}
	
	public void FirstName(String fname)
	{	
		WebElement Fname = ldriver.findElement(FirstName);
		waithelper1.waitElement(Fname);
		Fname.clear();
		Fname.sendKeys(fname);
	}
	
	public void LastName(String lname)
	{	
		WebElement Lname = ldriver.findElement(LastName);
		waithelper1.waitElement(Lname);
		Lname.clear();
		Lname.sendKeys(lname);
	}
	
	public void clickOnSearchBtn()
	{
		
         WebElement s1 = ldriver.findElement(Search);
          waithelper1.waitElement(s1);
          s1.click();
	}
	
	public int getNoOfRows()
	{
		 return ldriver.findElements(tableRow).size();
		
	}
	
	public int getNoOfColums()
	{
		int size = ldriver.findElements(tableColumn).size();
		return size;
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;

	    for(int i = 1; i < getNoOfRows(); i++)
	    {
	        WebElement emailID = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"));
	        String emailID1 = emailID.getText();
	        waithelper1.waitElement(emailID);

	        System.out.println(emailID);

	        if(emailID1.equalsIgnoreCase("victoria_victoria@nopCommerce.com"))
	        {
	            flag = true;
	            break; // Add a break statement to exit the loop once the email is found
	        }
	    }
	    return flag;
	}
	
	public boolean searchCustomerName(String Name)
	{
		boolean flag = false;

	    for(int i = 1; i < getNoOfRows(); i++)
	    {
	        WebElement name = ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"));
	        String name1 = name.getText();
	        waithelper1.waitElement(name);
	        System.out.println(name);
	        
	        String[] names = name1.split(" ");

	        if(names[0].equals("James") && names[1].equals("Pan"))
	        {
	            flag = true;
	            break; // Add a break statement to exit the loop once the email is found
	        }
	    }
	    return flag;
	}





	
	
	
	
	
}
