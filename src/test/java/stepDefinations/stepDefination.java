package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination extends baseTest {

	// adding Log4j logger
	private static Logger log = LogManager.getLogger(baseTest.class.getName());

	@Given("^Initailize chrome browser$")
	public void initailize_chrome_browser() throws Throwable {

		driver = initializeBrowser();// Browser Initialization
		log.info("Driver is initialised");

	}

	@Given("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_something_website(String strArg1) throws Throwable {

		driver.get("http://" + strArg1 + ".com/");// hitting the url
		log.info("Hitting the url");

	}

	
	
	@Given("^User clicks on Login Link to land on secure sign-in page$")
	public void user_clicks_on_login_link_to_land_on_secure_signin_page() throws Throwable {

		HomePage objHome = new HomePage(driver); // creating object of HomePage class
		log.debug("Clicking on Login link");
		objHome.LoginLink().click();
		log.info("Login Link is clicked");

	}
	
	@When("^User enter (.+) and (.+) and logs in$")
    public void user_enter_and_and_logs_in(String email, String password) throws Throwable {
		LoginPage objLogin = new LoginPage(driver);
		log.debug("Sending keys in email field");
		objLogin.EmailId().sendKeys(email);
		log.info("Email id is provided");

		log.debug("Sending keys in password field");
		objLogin.Password().sendKeys(password);
		log.info("password is provided");

		log.debug("Clicking on Login button");
		objLogin.LoginButton().click();
		log.info("Login button is clicked");
    }



	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		
		driver.close();
		log.info("Closing the browser");
	}

}