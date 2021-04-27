package E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Resuables {
	WebDriver driver;
	
	By signin = By.cssSelector("#nav-link-accountList-nav-line-1");//page object
	By SignIn_details = By.cssSelector(".a-input-text.a-span12.auth-autofocus.auth-required-field");
	By visible_text = By.xpath("//*[text()='Best Sellers']");
	By visible_error = By.xpath("//*[text()='There was a problem']");
	
	@FindBy(className="a-button-input")
	WebElement continue_;
	
	@FindBy(className="a-spacing-small")
	WebElement title;

	public Login_Resuables(WebDriver driver2driver) {
		this.driver = driver2driver;
		PageFactory.initElements(driver, this);
	}
	
public WebElement getsignin(){
	
	return driver.findElement(signin);	
}
public WebElement visible_text(){
	
	return driver.findElement(visible_text);	
}
public WebElement getsignin_info(){
	
	return driver.findElement(SignIn_details);
	
}
public WebElement get_visible_error(){
	
	return driver.findElement(visible_error);
	
}
public WebElement Continue(){
	
	return continue_;
	
}
public WebElement title(){
	
	return title;
	
}
}
