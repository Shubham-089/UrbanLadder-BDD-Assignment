package TestRunner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
	    features ={"C:\\Users\\Shubham.Yetonde\\Selenium_Assignments_File\\UrbanLadder_BDD_Assignment\\src\\test\\resources\\Features\\HomePage.feature"},
	    glue ={"stepDefinitions"},
	    plugin = {"pretty", "html:target/cucumber-reports"},
	    monochrome = true
	)
public class Runner  {

}
