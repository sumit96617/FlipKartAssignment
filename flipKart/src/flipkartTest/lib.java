package flipkartTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkartObjectRepository.AddToCartObjectRepository;
import flipkartObjectRepository.ItemSearchObjectRepository;
import flipkartObjectRepository.LoginObjectRepository;
import flipkartObjectRepository.logoutObjectRepository;

public class lib {
	protected static WebElement elementVisible = null;
    public static void Login(WebDriver driver,String Username,String Password) throws InterruptedException{
	  
	  LoginObjectRepository.link_Login(driver).click();
      LoginObjectRepository.txtbox_username(driver).sendKeys(Username);
      LoginObjectRepository.txtbox_password(driver).sendKeys(Password);
      LoginObjectRepository.button_Login(driver).click();
     // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      Thread.sleep(3000);
      LoginObjectRepository.link_MyAccount(driver).click();
    /*  elementVisible = lib.waitCondtion(driver,LoginObjectRepository.link_MyAccount(driver));
      elementVisible.click();
      elementVisible = lib.waitCondtion(driver,LoginObjectRepository.link_UpdateEmailMobile(driver));
      elementVisible.click();*/
      Thread.sleep(4000);
      LoginObjectRepository.link_UpdateEmailMobile(driver).click();
      String emailId = LoginObjectRepository.span_Email(driver).getText();
      String mobileNumber= LoginObjectRepository.span_Mobile(driver).getText();
      if(Username.equalsIgnoreCase(emailId) || Username.equalsIgnoreCase(mobileNumber)){
       	Assert.assertTrue(true);
      }
      
      else{
    	Assert.assertTrue(false, "If Assertion got failed then it means login got failed");
      }
      Thread.sleep(3000);
      LoginObjectRepository.div_HomeScreen(driver).click();
      Thread.sleep(4000);
  }
  

    public static void itemSearchValidation(String itemToSearch,WebDriver driver) throws InterruptedException{
	  ItemSearchObjectRepository.itemSearchBox(driver).sendKeys(itemToSearch);
	  ItemSearchObjectRepository.buttonSearch(driver).click();
	  Thread.sleep(6000);
	  String totalNumberOfResults = ItemSearchObjectRepository.totalNumberOfSearch(driver).getText();
	  List<WebElement> element = ItemSearchObjectRepository.totalItems(driver);
	  String totalItemDisplayed=Integer.toString(element.size());
	  Assert.assertEquals(totalNumberOfResults, totalItemDisplayed,"If the assertion failed total number of items displayed is not correct");
	  String arrayOfStringSearch [] = itemToSearch.split(" ");

	  for(int i=0;i<element.size();i++){
		    String itemName =element.get(i).getText();
		    boolean value = itemName.toLowerCase().contains(arrayOfStringSearch[0].toLowerCase());
		    Assert.assertTrue(value,"If the assertion get failed it means items which shows in the result is not correct");   
       } 
  }
  
     public static void addToKartItemForMaxPrice(String itemToSearch,WebDriver driver,int numberOfItemsToAddToCart) throws InterruptedException{
		 List<WebElement> element = ItemSearchObjectRepository.totalItems(driver);
		 List<WebElement> price = ItemSearchObjectRepository.totalPriceOfItems(driver);
		 int indexForMaxPrice=searchMaxpriceIndex(price, numberOfItemsToAddToCart, element, itemToSearch);
		 element.get(indexForMaxPrice).click();
		 elementVisible = lib.waitCondtion(driver,AddToCartObjectRepository.addToKart(driver));
	     //elementVisible.click();
		 String addToCart =elementVisible.getText();
		 if("ADD TO CART".equalsIgnoreCase(addToCart)){
			 elementVisible.click();
	     	}
		 Thread.sleep(2000);
		 AddToCartObjectRepository.goToKart(driver).click();
	 }
	 
     
     public static int searchMaxpriceIndex(List<WebElement> price, int numberOfItemsToAddToCart,List<WebElement> element,String itemToSearch){
    	 int maxPrice =0;
    	 int indexOfMaxPrice=0;
         
    	 for(int i =0;i<numberOfItemsToAddToCart;i++){
    		 String textofItem = element.get(i).getText();

    		 if(textofItem.toLowerCase().indexOf(itemToSearch.toLowerCase())!=-1 && textofItem.indexOf("Out Of Stock")==-1){
    		 String textOfPrice = price.get(i).getText();
        	 int priceOfItem =Integer.parseInt(textOfPrice.substring(1,textOfPrice.length()).replace(",",""));
    		 maxPrice=priceOfItem;
		     indexOfMaxPrice=i;
    		 break;
    	   }
    	 }
    	
    	 for(int j=indexOfMaxPrice+1;j<numberOfItemsToAddToCart;j++){
    		 String textOfPrice = price.get(j).getText();
        	 int priceOfItem =Integer.parseInt(textOfPrice.substring(1,textOfPrice.length()).replace(",",""));
    		 String textofItemForPriceCheck = element.get(j).getText();
     		 if(textofItemForPriceCheck.toLowerCase().indexOf(itemToSearch.toLowerCase())!=-1 && textofItemForPriceCheck.indexOf("OUT OF STOCK")==-1 && priceOfItem> maxPrice){
    			 maxPrice=priceOfItem;
    			 indexOfMaxPrice=j;
    		}
    		 
    	 }
             
    		 
      return indexOfMaxPrice;

  }
     
    public static void CompareItems(WebDriver driver, String browser, String nameForScreenShotOfCompareItems) throws Exception{
    	List<WebElement> elements=ItemSearchObjectRepository.div_addToCompare(driver);
        	for(int i=0;i<3;i++){
    		elements.get(i).click();
    	  }
    	ItemSearchObjectRepository.butn_compare(driver).click();
    	Thread.sleep(4000);
    	takeScreenshot(driver,nameForScreenShotOfCompareItems,browser);
    	}
   
    
     
    public static void takeScreenshot(WebDriver driver,String browser,String nameOfScreenshot) throws Exception{
    	
    	 TakesScreenshot ts = (TakesScreenshot)driver; 
         File source =  ts.getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(source, new File("./screenShots/"+browser+nameOfScreenshot));
         Thread.sleep(2000);
    }
    
    public static WebElement waitCondtion(WebDriver driver, WebElement element){
    	WebElement elementVisible=null;
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	elementVisible = wait.until(ExpectedConditions.visibilityOf(element));
    	return elementVisible;
    }
    
    public static void logout(WebDriver driver) throws Exception{
    	LoginObjectRepository.div_HomeScreen(driver).click();
    	Thread.sleep(3000);
    	logoutObjectRepository.butn_Logout(driver).click();
    	Thread.sleep(8000);
        
     }
}