package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/searchFeatures.feature", glue = {"stepDefinitions"}, dryRun = false, plugin = {"pretty","json:target/MyReports/report.json","junit:target/MyReports/report.xml","html:target/MyReports/report.html"},publish = true)
public class testRun {

}
