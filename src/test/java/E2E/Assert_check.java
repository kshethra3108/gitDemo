package E2E;
  
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.base;
//@Listeners(E2E.Listener.class)
public class Assert_check extends base{
	public WebDriver driver;	
	private static Logger log = LogManager.getLogger(Assert_check.class.getName());
	@BeforeTest
public void Intialize() throws IOException {
	driver = initBrowser();
	log.info("Driver intialized");
	}	
	
	@Test
	public void E2e() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("Url triggered");
		//we can get class using two ways 1. extends class 2.creating an object to the class
		Login_Resuables Login = new Login_Resuables(driver);
		Assert.assertTrue(Login.visible_text().isDisplayed());
		log.info("It is successfully displayed");
		//Login_Resuables Login = new Login_Resuables(driver);
		Assert.assertTrue(Login.visible_text().equals("abc"));
		log.info("It is not matched");
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
