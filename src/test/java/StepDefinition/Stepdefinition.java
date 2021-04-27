package StepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

import E2E.Login;
import E2E.Login_Resuables;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import resources.base;


@RunWith(Cucumber.class)
public class Stepdefinition extends base {
	Login_Resuables Login = new Login_Resuables(driver);
	private static Logger log = LogManager.getLogger(Stepdefinition.class.getName());
	@Given("^Navigate into amazon application \\\"([^\\\"]*)\\\"$")
	public void navigate_into_amazon_application(String uRL) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initBrowser();
		log.info("Driver intialized");
		driver.get(uRL);
		log.info("Successfully loaded");
	}

	@Given("^Verify whether and required link is displayed$")
	public void verify_whether_and_required_link_is_displayed() throws Throwable {
		Login_Resuables Login = new Login_Resuables(driver);
		Login.visible_text().click();
		Assert.assertTrue(Login.visible_text().isDisplayed());
log.info("Text is visible");
	}

	@When("^Username is provided inside signin link as (.+)$")
	public void username_is_provided_inside_signin_link(String Email) throws Throwable {
		Login_Resuables Login = new Login_Resuables(driver);
		Login.getsignin().click();
		Login.getsignin_info().sendKeys(Email);	
		Login.Continue().click();
		Assert.assertEquals(Login.title().getText(),"Sign-In");
		log.info("Successfully navigated to page and entered details");   
	}

	@Then("^it should return proper message$")
	public void it_should_return_proper_message() throws Throwable {
		Login_Resuables Login = new Login_Resuables(driver);
	    log.info(Login.get_visible_error().getText());
	    log.info("Error message displayed");
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.close();
	   log.info("Briwser closed");
driver.quit();
log.info("browser quit");
	}

    
       
    }
