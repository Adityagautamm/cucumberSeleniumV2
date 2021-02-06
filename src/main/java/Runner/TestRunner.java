package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(
			//features = "C:\\Users\\Aditya Gautam\\eclipse-workspace\\CucumberProject\\src\\main\\java\\Feature\\flight.feature", //the path of the feature files
			features = "C:\\Users\\Aditya Gautam\\eclipse-workspace\\CucumberProjectV2\\src\\main\\java\\Feature",
			glue={"Steps"}, //the path of the step definition files
			monochrome = true, //display the console output in a proper readable format
			//strict = true, //it will check if any step is not defined in step definition file
			dryRun = false //to check the mapping is proper between feature file and step def file
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}
			//tags = {"@second"}			
			
			)
	 
	public class TestRunner {
	 
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest


