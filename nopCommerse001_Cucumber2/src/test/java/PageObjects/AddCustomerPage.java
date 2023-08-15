package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(ldriver, this);
	}

	By lnkCustomer_Menu = By.xpath("//nav[@class='mt-2']/ul/li[4]");

	By lnkCustomer_menuitem = By.xpath("//nav[@class='mt-2']/ul/li[4]//p[text()=' Customers']");

	By AddNew = By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	
	By txtPassword = By.xpath("//input[@id='Password']");
	
	By FName = By.xpath("//input[@id='FirstName']");
	
	By LName = By.xpath("//input[@id='LastName']");
	
	By genderMale = By.xpath("//input[@id='Gender_Male']");
	
	By genderFemale = By.xpath("//input[@id='Gender_Female']");
	
	By DOB = By.xpath("//input[@id='DateOfBirth']");
	
	By CompanyName = By.xpath("//input[@id='Company']");
	
	By TaxExmpted = By.xpath("//input[@id='IsTaxExempt']");
	
	By Newsletter = By.xpath("(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]");
	
	By NewsStoreName = By.xpath("//li[text()='Your store name']");
	
	By NewsTestStore = By.xpath("//li[text()='Test store 2']");
	
	By CustomerRole = By.xpath("(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[2]");
	
	By Administrators = By.xpath("//li[text()='Administrators']");
	
	By ForumModerators = By.xpath("//li[text()='Forum Moderators']");
	
	By Guests = By.xpath("//li[text()='Guests']");
	
	By Registered = By.xpath("//li[text()='Registered']");
	
	By Vendors = By.xpath("//li[text()='Vendors']");
	
	By ManagerVendor = By.xpath("//select[@id='VendorId']");
	
	By Vendor1 = By.xpath("//*[text()='Vendor 1']");
	
	By Vendor2 = By.xpath("//*[text()='Vendor 2']");
	
	By active = By.xpath("//input[@id='Active']");
	
	By AdminComment = By.xpath("//*[@id='AdminComment']");
	
	By SaveBtn = By.xpath("//button[@name='save']");
	
	By ConfirmationMSG = By.xpath("//div[@class='alert alert-success alert-dismissable']");
	
	//actoions method
	public String getTitle()
	{
		return ldriver.getTitle();
	}
	
	
	public void ClickOnCustomerMenu()
	{
		ldriver.findElement(lnkCustomer_Menu).click();
	}
	
	public void ClickOnCustomerMenuItem()
	{
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	
	public void ClickOnAddNew()
	{
		ldriver.findElement(AddNew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	
	public void FirstName(String Fname)
	{
		ldriver.findElement(FName).sendKeys(Fname);
	}
	
	public void LastName(String Lname)
	{
		ldriver.findElement(LName).sendKeys(Lname);
	}
	
	public void SetDOB(String dob)
	{
		ldriver.findElement(DOB).sendKeys(dob);
	}
	
	public void companyName(String name)
	{
		ldriver.findElement(CompanyName).sendKeys(name);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(genderMale).click();
		}
		
		else if(gender.equals("Female"))
		{
			ldriver.findElement(genderFemale).click();
		}
		
		else
		{
			ldriver.findElement(genderMale).click();
		}
		
	}
	
	public void SetManagerVendor(String value)
	{
		WebElement vendor = ldriver.findElement(ManagerVendor);
		Select s=new Select(vendor);
		s.selectByVisibleText(value);
	}
	
	public void setAdminComment(String comment)
	{
		 ldriver.findElement(AdminComment).sendKeys(comment);
		
	}	
	
	public void setCustomerRoles(String role) throws InterruptedException
	{
		ldriver.findElement(CustomerRole).click();
		
		if(!role.equals("vendor"))
		{
			ldriver.findElement(By.xpath("//span[@title='delete']")).click();
		}
		
		
		
		WebElement listitem;
		
		Thread.sleep(1000);
		
		if(role.equals("Administrators"))
		{
			listitem =ldriver.findElement(Administrators);
		}
		else if(role.equals("ForumModerators"))
		{
			listitem =ldriver.findElement(ForumModerators);
		}
		
		else if(role.equals("Guests"))
		{
			listitem =ldriver.findElement(Guests);
		}
		
		else if(role.equals("Registered"))
		{
			listitem =ldriver.findElement(Registered);
		}
		
		else if(role.equals("Vendors"))
		{
			listitem =ldriver.findElement(Vendors);
		}
		
		else
		{
			listitem =ldriver.findElement(Guests);
		}
		
	//	listitem.click();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listitem);
	}
	
	public void saveBtn() throws InterruptedException
	{
		ldriver.findElement(SaveBtn).click();
		Thread.sleep(3000);
	}
	
	public void UserConfirmationMessage(String text)
	{
		boolean actResult = ldriver.findElement(ConfirmationMSG).getText().contains("The new customer has been added successfully.");
		Assert.assertTrue(actResult);
		
	}
	
	
	
}
