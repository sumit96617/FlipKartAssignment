package flipkartObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartObjectRepository {
	
	private static WebElement element = null;

	  public static WebElement addToKart(WebDriver driver){	
		  element =  driver.findElement(By.xpath("//*[@class='_2AkmmA _3Plo8Q _19RW-r']"));		  
		  return element;
		  
	  }

	  public static WebElement goToKart(WebDriver driver){		  
		  element =  driver.findElement(By.xpath("//a[@class='_3NFO0d']"));
		  return element;
		  
	  }
	  
	  public static WebElement removeRecentAddedItemFromKart(WebDriver driver){
		  element = driver.findElement(By.xpath("//span[text()='Remove']"));
		  return element;
		  
	  }

}
