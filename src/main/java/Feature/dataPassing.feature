#---------without Examples Keyword
#Scenario: Free CRM Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "naveenk" and "test@123"
#Then user clicks on login button
#Then user is on home page
#
#
#---------with Examples Keyword
#Scenario Outline: Free CRM Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "<username>" and "<password>"
#Then user clicks on login button
#Then user is on home page
#Then Close the browser
#
#
#Examples:
#	| username | password |
#	| naveenk  | test@123 |
#	|  tom     | test456  |


#---------without Examples Keyword
#Scenario: Free CRM Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "naveenk" and "test@123"
#Then user clicks on login button
#Then user is on home page


#---------with Examples Keyword
#Scenario Outline: Free CRM Login Test Scenario

#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "<username>" and "<password>"
#Then user clicks on login button
#Then user is on home page
#Then Close the browser
#
#
#Examples:
#	| username | password |
#	| naveenk  | test@123 |
#	|  tom     | test456  |

#//	@Then("^user enters username and password$")
#//	public void user_enters_username_and_password(DataTable credentials) {
#//		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
#//
#//			driver.findElement(By.name("username")).sendKeys(data.get("username"));
#//			driver.findElement(By.name("password")).sendKeys(data.get("password"));
#//
#//		}

#---------hOW TO USE MAPS to pass data
#Feature: Deal data creation 
#
#Scenario: Free CRM Create a new deal scenario 
#
#	Given user is already on Login Page 
#	When title of login page is Free CRM 
#	Then user enters username and password 
#		| username | password|
#		| naveenk | test@123 |
#		
#//	@Then("^user enters username and password$")
#//	public void user_enters_username_and_password(DataTable credentials) {
#//		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
#//
#//			driver.findElement(By.name("username")).sendKeys(data.get("username"));
#//			driver.findElement(By.name("password")).sendKeys(data.get("password"));
#//
#//		}

#---------how to use lists to get data (without header)
#Then user clicks on login button
#Then user is on home page
#Then user moves to new deal page
#Then user enters deal details
#| test deal | 1000 | 50 | 10 |
#
#//	 @Then("^user enters deal details$")
#//	 public void user_enters_contacts_details(DataTable dealData){
#//		 List<List<String>> dealValues =  dealData.raw();
#//		 driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
#//		 driver.findElement(By.id("amount")).sendKeys(dealValues.get(0).get(1));
#//		 driver.findElement(By.id("probability")).sendKeys(dealValues.get(0).get(2));
#//		 driver.findElement(By.id("commission")).sendKeys(dealValues.get(0).get(3));
#//	 }