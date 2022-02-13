package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDefinations","TestHooks"},stepNotifications = true,
		plugin ={"pretty","json:target/cucumber/Cucumber.json","html:target/cucumber/cucumber-html-report.html"},
				 monochrome = true)
public class AddAppTestRunner {

}
