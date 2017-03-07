package flipkartTest;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flipkartObjectRepository.AddToCartObjectRepository;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import flipkartTest.lib;
public class FlipKartTest {
 
	public WebDriver driver;
	
	
   @BeforeTest
   @Parameters({"browser","pathForFirefoxDriver","pathForChromeDriver"})
   
    public void openBrowser(String browser,String pathForFirefoxDriver,String pathForChromeDriver) throws InterruptedException{
     
	//Opening application
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
		  lib.itemSearchValidation(itemToSearch,driver);
	 	}
	 
     @Test (priority = 2)
     @Parameters({"itemToSearch","totalNumberOfItemsToAdd","nameOfScreenshotForCartItems","browser"})
    
	 public void addToKart(String itemToSearch, int totalNumberOfItemsToAdd,String nameOfScreenshotForCartItems, String browser) throws Exception{
    	// calling Method from lib file
    	 
       lib.addToKartItemForMaxPrice(itemToSearch, driver, totalNumberOfItemsToAdd);
       Thread.sleep(8000);
       lib.takeScreenshot(driver, browser,nameOfScreenshotForCartItems);
       WebElement element =lib.waitCondtion(driver, AddToCartObjectRepository.removeRecentAddedItemFromKart(driver));
	   element.click();
	   Thread.sleep(3000);
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
   
 
	

	     
		

   
	  
	  
	  
	  
	  
  