package flipkartTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipKartCompareItemTest {

	public WebDriver driver;
	
	
	   @BeforeTest
	   @Parameters({"browser","pathForFirefoxDriver","pathForChromeDriver"})
	   
	    public void openBrowser(String browser,String pathForFirefoxDriver,String pathForChromeDriver) throws InterruptedException{
	     
		
			   if(browser.equalsIgnoreCase("chrome")){
			  System.setProperty("webdriver.chrome.driver",pathForChromeDriver);
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  driver.navigate().to("https://flipkart.com");	
			   
		          }
			   else if(browser.equalsIgnoreCase("firefox")){
				  System.setProperty("webdriver.gecko.driver",pathForFirefoxDriver);
			      driver = new FirefoxDriver();
				  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				  driver.navigate().to("https://flipkart.com");	  
				   
				   
				   
			   }
			 }
		   
		 
		
		@Test (priority=0)
		@Parameters({"Username","Password"})
	    
	 
	     public void flipKartLogin(String Username,String Password) throws InterruptedException{
			// calling Method from lib file
			
		    lib.Login(driver, Username, Password);
		}
		  
		
		 @Test (priority = 1)
		 @Parameters({"itemToSearch"})
		 
		 
		 
		  public void searchItemValidation(String itemToSearch) throws InterruptedException {
			 // Calling Method from lib file

			 lib.itemSearchValidation(itemToSearch,driver);
		}
		 
		 
		 @Test (priority=2)
		 @Parameters({"nameForScreenShotOfCompareItems","browser"})
		 
		
		 public void CompareItems(String browser, String nameForScreenShotOfCompareItems) throws Exception{
			 // Calling Method from lib file
			 
			 lib.CompareItems(driver,browser,nameForScreenShotOfCompareItems);
			 
		 }
		 
	     @Test (priority = 3)
	     
	     public void logout() throws Exception{
	    	lib.logout(driver); 
	    	 
	     }
	     
	     @Test (priority = 4)
	     
	     public void closeBrowser(){
	    	 
	    	 driver.quit();
	     }
}
