package TestRunner;

//import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature",
		glue="StepDefinition")
public class TestRunner extends AbstractTestNGCucumberTests {

}
