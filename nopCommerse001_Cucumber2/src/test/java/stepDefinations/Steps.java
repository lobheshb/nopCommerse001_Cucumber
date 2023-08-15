package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass {
	public WebDriver driver;

	@Before
	public void setup() throws IOException {
		
		configProp=new Properties();
		FileInputStream file=new FileInputStream("config.properties");
		configProp.load(file);
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					configProp.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
		}
		// logger=Logger.getLogger("nopCommerce");
		// PropertyConfigurator.configure("log4j.properties");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// logger.info("****** Launching browser *********");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {

		// logger.info("***** Launching URL *********");
		driver.get(url);

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String Password) throws InterruptedException {
		// logger.info("**** providing Login Details ****");

		lp.setUsername(username);
		lp.setPassword(Password);
	}

	@When("Click on Login")
	public void click_on_login() {
		// logger.info("*** started login **********");
		lp.clickOnLogin();
		;

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			// logger.info("***** Login Passed****");
			Assert.assertTrue(false);
		} else {
			// logger.info("*** login Failed ****");
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("User clicks on Log out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
		lp.clickOnLogout();
		// logger.info("*** logout successfully *****");
		Thread.sleep(2000);
	}

	@Then("close browser.")
	public void close_browser() {
		driver.quit();
	}

	// customer specification..........

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		// logger.info("******* Adding customer *****");
		// logger.info("***** add customer data *****");
		addcust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(2000);
		addcust.ClickOnCustomerMenu();
	}

	@When("User click on customer Menu Item")
	public void user_click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addcust.ClickOnCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addcust.ClickOnAddNew();
	}

	@Then("User can view Add new Customer")
	public void user_can_view_add_new_customer() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getTitle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {

		String email = randomstring() + "@gmail.com";

		addcust.setEmail(email);

		addcust.setPassword("admin123");
		// Registered -default
		// The customer can not in both 'Guest' and 'Registered ' customer role
		// add the customer to 'guest' or 'registered' customer role

		addcust.setCustomerRoles("Guests");
		Thread.sleep(2000);
		addcust.SetManagerVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.FirstName("Lobhesh");
		addcust.LastName("Bole");
		addcust.SetDOB("5/23/1995");
		addcust.companyName("TCS");
		addcust.setAdminComment("This is for testing......");

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addcust.saveBtn();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		addcust.UserConfirmationMessage(string);
	}

	// specify the customer by email

	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		searchcust = new SearchCustomerPage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
		Thread.sleep(2000);

	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchcust.clickOnSearchBtn();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {

		boolean status = searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	@Then("close browser1")
	public void close_browser1() {
		driver.quit();
	}

	// find the customer from table by fname and last name

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchcust = new SearchCustomerPage(driver);
		searchcust.FirstName("James");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchcust.LastName("Pan");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		Thread.sleep(3000);
		boolean status = searchcust.searchCustomerName("James Pan");
		Assert.assertEquals(true, status);

	}

	@Then("close browser2")
	public void close_browser2() {
		driver.quit();
	}
//	@After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }

	}
