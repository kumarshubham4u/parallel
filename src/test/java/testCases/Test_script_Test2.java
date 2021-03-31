package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.baseTest;

public class Test_script_Test2 extends baseTest {
	public WebDriver driver;// declaring a driver locally for parallel testing in future

	// adding Log4j logger
	private static Logger log = LogManager.getLogger(baseTest.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));// hitting the url
	}

	@Test
	public void validateElements() throws InterruptedException, IOException {
		// Validating elements now
		HomePage objHome = new HomePage(driver);
		Assert.assertTrue(objHome.NavBar().isDisplayed());
		log.info("Navigation Bar validated");
		Thread.sleep(2000);
		Assert.assertEquals(objHome.ContactMail().getText(), "info@qaclickacademy.coms");
		log.info("Contact mail validated");

	}

	@AfterMethod
	public void teardown() {

		// closing driver
		driver.close();
	}

}
