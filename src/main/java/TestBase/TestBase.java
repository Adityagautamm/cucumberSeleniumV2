package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.POIXMLProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.ScenarioContext;
import Util.EventListenerClass;
import Util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static EventListenerClass eventListener;
	public static FluentWait<WebDriver> fluentWait;
	public static JavascriptExecutor executor;
	public static Actions builder;
	public static ScenarioContext scenarioContext;
	

	public static void initialization() {

		//Properties file set up
		prop = new Properties();
		System.out.println("file creating");
		
		try {
			FileInputStream ip= new FileInputStream(
			"C:\\Users\\Aditya Gautam\\eclipse-workspace\\CucumberProjectV2\\src\\main\\java\\resources\\config.properties");
			prop.load(ip);
		}
		
	
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//Setting up Driver
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aditya Gautam\\Desktop\\curious fella\\Automation\\webdriver\\chrome\\chromedriver.exe");
			                                               
			 driver= new ChromeDriver();
		}
		
		wait= new WebDriverWait(driver, 15);
		
		 fluentWait = new FluentWait<WebDriver>(driver);
		 builder= new Actions(driver);
		 executor = (JavascriptExecutor) driver;
		
		e_driver= new EventFiringWebDriver(driver);
		// Now create object of  EventListnerHandler to register it with 
		//EventFiringWebDriver
		eventListener= new EventListenerClass();
		e_driver.register(eventListener);
		driver=e_driver;
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 //dynamic wait
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PageTimout, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWAiT, TimeUnit.SECONDS);
		 
		driver.get(prop.getProperty("url"));
		
		// Setting up Scenario context object
		scenarioContext = new ScenarioContext();
			}
	
	
	public static void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scenarioContext.resetContext();
		driver.quit();
	}
	
	

}
