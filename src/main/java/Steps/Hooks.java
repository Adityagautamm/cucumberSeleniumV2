package Steps;

import Pages.AllPageBase;
import TestBase.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public static void setup() {
		TestBase.initialization();
		AllPageBase.LoadAllPages();
		
	}
	
	@After
	public static void tearDown() {
		
		TestBase.tearDown();
		
	}
	
}
