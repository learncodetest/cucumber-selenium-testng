package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
											features = "src/test/resources/features", 
											glue = "tests", 
											monochrome = true,
											plugin={"json:target/cucumber-report/cucumber.json"})
public class CucumberRunner extends AbstractTestNGCucumberTests{

}