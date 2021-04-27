package E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class Login extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Login.class.getName());
	@BeforeTest
public void Intialize() throws IOException {
	driver = initBrowser();
	log.info("Driver intialized");
	}	
	
	@Test(dataProvider="getdata")
	public void E2e(String URL , String Email) throws IOException, InterruptedException {
		driver.get(URL);
		log.info("Successfully loaded");
		//we can get class using two ways 1. extends class 2.ccreating an object to the class
		Login_Resuables Login = new Login_Resuables(driver);
		Assert.assertTrue(Login.visible_text().isDisplayed());
		//log.info("Successfully displayed");
		Login.getsignin().click();
		Login.getsignin_info().sendKeys(Email);	
		Login.Continue().click();
		Assert.assertEquals(Login.title().getText(),"Sign-In");
		log.info("Successfully SIgned in");
	
	}
	@DataProvider
	public Object[][] getdata() {
		//Object[][] data = new Object[0][0];
		Object[][] data = new Object[1][2];

		data[0][0]="https://www.amazon.com/";
		data[0][1]="kshethra";
		
//		data[1][0]="https://www.amazon.com/";
//		data[1][1]="thanishka";
//		
//		data[2][0]="https://www.amazon.com/";
//		data[2][1]="yashmitha";
		return data;
		
	}
	
	@AfterTest
	public void teardown() {
	//	driver.close();
	}
	
}
