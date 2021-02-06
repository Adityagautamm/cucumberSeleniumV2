package Steps;

import Pages.AllPageBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ActionSteps extends AllPageBase {
	
	@When("^I Navigate to \"([^\"]*)\" Page$")
	public void i_Navigate_to_Page(String pageName) throws Throwable {

        // setting the object
        BasicSteps.SetObject(pageName);

        // Getting the object and directing to the URL
        BasicSteps.NavigateToUrl(BasicSteps.GetStoredPageUrl());
	}

	@When("^I clicks on \"(.*)\" (?:link|button|element)$")
	public void user_clicks_on(String elementName) throws Exception  {

		BasicSteps.click(driver.findElement(BasicSteps.GetWebElement(elementName)));
					
	} 

	@When("^I save the value of element \"([^\"]*)\" as alias \"([^\"]*)\"$")
	public void i_save_the_value_of_element_as_alias(String elementName, String aliasName) throws Throwable {
	    
		// getting web element value
		String value= BasicSteps.getText(driver.findElement(BasicSteps.GetWebElement(elementName)));
		
		// storing the value in context
		scenarioContext.setContext(aliasName, value);		
	}

	@Given("^user enters \"([^\"]*)\" on \"([^\"]*)\" textbox$")
	public void user_enters_on_textbox(String text, String element) throws Exception  {

		
	}

	}

