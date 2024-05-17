package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/myntraPaginationFeatures.feature", glue = {"stepDefinitions"}, dryRun = false, plugin = {"pretty","json:target/MyReports/MyntraReports/report.json","junit:target/MyReports/MyntraReports/report.xml","html:target/MyReports/MyntraReports/report.html"},publish = true)
public class myntraTestRun {

}
