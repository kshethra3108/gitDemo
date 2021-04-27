package resources;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class EXTENTReportNG {
		static ExtentReports extent;

	public static ExtentReports config()
	{
	// ExtentReports , ExtentSparkReporter
	String path =System.getProperty("user.dir")+"\\reports\\index.html"; // This is used to store the reports in this location. User.dir will give us current directory
	ExtentSparkReporter reporter = new ExtentSparkReporter(path); //This sub class is to perform                             ExtentSparkReporter functionlaities
	reporter.config().setReportName("Web Automation Results");//set reportername
	reporter.config().setDocumentTitle("Test Results");//set document title
	extent =new ExtentReports();//Main extentreports class file to attach to reports and display screen
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Kshethra");//Tester name
	return extent;
	}
//	@Test
//	public void initialDemo()
//	{
//	ExtentTest test= extent.createTest("Initial Demo");//ExtentTest class is used to get the response found by extentclass object. CreateTest is for creating a name.
//	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//	WebDriver driver =new ChromeDriver();
//	driver.get("https://rahulshettyacademy.com");
//	System.out.println(driver.getTitle());
//	driver.close();
//	//test.fail("Result do not match");// this command is to purposefully failing it
//	extent.flush();// This should be used whenever extent is used.
//	}
	}