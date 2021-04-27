package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.EXTENTReportNG;
import resources.base;

public class Listener extends base implements ITestListener {
	 ExtentReports extent = EXTENTReportNG.config();
     ExtentTest test;
     ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test = extent.createTest(result.getMethod().getMethodName());//ExtentTest class is used to get the response found by extentclass object. CreateTest is for creating a name.
	extent_test.set(test);//this will load test to extenttest
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test PASSED");
		extent_test.get().log(Status.PASS, "Test PASSED");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	//	test.fail(result.getThrowable());
		extent_test.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testcasename = result.getMethod().getMethodName();//this will give us test case name
	 try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 		try {
		 extent_test.get().addScreenCaptureFromPath(getscreeshot(testcasename,driver), result.getMethod().getMethodName());//this is get screenshot in extentreport paramaeters(destination location,Methodname)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
