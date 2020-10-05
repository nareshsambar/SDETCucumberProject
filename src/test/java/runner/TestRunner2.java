package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue = {"stepDefinition"},
		tags= "@activityCRM",
		plugin = {"pretty", "html: test-reports-CRM"},
		monochrome = true
		)

public class TestRunner2 {
	//Nothing is written here
}
