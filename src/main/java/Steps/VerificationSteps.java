package Steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Pages.AllPageBase;
import cucumber.api.java.en.Then;

public class VerificationSteps extends AllPageBase {

	
	@Then("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String pageName) throws Throwable {
        // setting the object
        BasicSteps.SetObject(pageName);

        // Getting the object and directing to the URL
        String storedUrl = BasicSteps.GetStoredPageUrl();

        String currentPageUrl = BasicSteps.getUrl();

        Assert.assertTrue(storedUrl.equals(currentPageUrl));
	}
	

	@Then("^I Verify the element \"([^\"]*)\" to be equal to alias \"([^\"]*)\"$")
	public void i_Verify_the_element_to_be_equal_to_alias(String elementName, String aliasName) throws Throwable {


        // Getting the element
        WebElement element = driver.findElement(BasicSteps.GetWebElement(elementName));
        String elementValue= BasicSteps.getText(element);
        String aliasValue= scenarioContext.getContextinString(aliasName);
        Assert.assertTrue(elementValue.equals(aliasValue));
	}

}
