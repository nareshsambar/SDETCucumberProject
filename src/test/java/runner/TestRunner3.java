package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue = {"stepDefinition"},
		tags= "@activityHRM",
		plugin = {"pretty", "html: test-reports-HRM"},
		monochrome = true
		)

public class TestRunner3 {
	//Nothing is written here
}
