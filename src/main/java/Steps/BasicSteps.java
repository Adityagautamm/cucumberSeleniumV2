package Steps;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AllPageBase;

public class BasicSteps extends AllPageBase {

	 	
    // Set object for the current page
    public static void SetObject(String pageName)
    {
        if (AllPageBase.pageStorage.containsKey(pageName))
        {
        	AllPageBase.theObject =   AllPageBase.pageStorage.get(pageName);
        }
    }
    
    
    // Get object for the current page
    public static AllPageBase GetObject()
    {
        return AllPageBase.theObject;

    }
    
    // Get Web element value of current page as per the object we set
    public static By GetWebElement(String elementName)
    {
    	Object propertyValue = null;
    	 Type propertyType = null;
        // removing White spaces from Page Name
        elementName = convertToTitleCaseIteratingChars(elementName);
        elementName = elementName.replaceAll("\\s","");
        
        AllPageBase allPages = GetObject();
       
		try {
		    Field field = allPages.getClass().getDeclaredField(elementName);
		    propertyValue = field.get(allPages);
            propertyType= field.getType();
		 		}

        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (propertyType.equals(By.class))
      {
          return (By)propertyValue;
      }

      else
      {
          return null;
      }


    }
        // Get URL variable of currect page as per the object we set
        public static String GetStoredPageUrl()
        {

        	Object propertyValue = null;
       	    Type propertyType = null;
           
           AllPageBase allPages = GetObject();
          
   		try {
   		    Field field = allPages.getClass().getDeclaredField("url");
   		    propertyValue = field.get(allPages);
               propertyType= field.getType();
   		 		}

   	 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     if (propertyType.equals(String.class))
   {
       return (String)propertyValue;
   }

   else
   {
       return null;
   }

       
        }



   
 
    
    public static String convertToTitleCaseIteratingChars(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }
        return converted.toString();
    }
	
	    public static void waitForElementToBeClickable(WebElement element, int timeout, int pollTimeout) {
	        fluentWait.withTimeout(Duration.ofSeconds(timeout));
	        fluentWait.pollingEvery(Duration.ofSeconds(pollTimeout));
	        fluentWait.ignoring(NoSuchElementException.class);
	        fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	        fluentWait.until(ExpectedConditions.visibilityOf(element));
	        
	    }
	 
	 
	 public static void waitForElementsToBeVisible(List<WebElement> elements,  int timeout, int pollTimeout) {
		   
		        fluentWait.withTimeout(Duration.ofSeconds(timeout)); 
		        fluentWait.pollingEvery(Duration.ofSeconds(pollTimeout));
		        fluentWait.ignoring(NoSuchElementException.class);
		        fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
		        
		    }
 
	



	public static String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	
	public static String getPageHeader( WebElement element) {
		// TODO Auto-generated method stub
		return element.getText();
	}

	
	public static void NavigateToUrl( String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
	
	public static void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			
			
		} catch (Exception e) {
			System.out.println("Some error occured while waiting for element");
		}
	}

	public static void enterText(WebElement element, String text) {
		// TODO Auto-generated method stub
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getText(WebElement element) {
		// TODO Auto-generated method stub
		 return element.getText();
	}
	
	public static void click(WebElement element)  {
		
		waitForElementToBeClickable(element, 10, 1);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
	}
	
    public static String getUrl()  {
		
		return driver.getCurrentUrl();
	}
	
	public static void mouseOverElement(WebElement element) {
		// TODO Auto-generated method stub
		builder.moveToElement(element);
	}

	
	public static void performAction() {
		// TODO Auto-generated method stub
		builder.build().perform();
	}
	
	public static void switchToFrame(int index) {
		driver.switchTo().frame(0);
		
	}
	
	public static Set<String> getWindows() {
		return driver.getWindowHandles();
		
	}
	
	
	
}

