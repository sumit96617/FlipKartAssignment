package flipkartObjectRepository;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemSearchObjectRepository {

	private static WebElement element = null;
	private static List<WebElement> elements = null;

	  public static WebElement itemSearchBox(WebDriver driver){		  
	   element=driver.findElement(By.xpath("//*[@class='LM6RPg']"));	  
	   return element;		  
		  
	  }
	  
	  public static WebElement buttonSearch(WebDriver driver){		  
		  element = driver.findElement(By.xpath("//*[@class='_2BhAHa']"));		  
		  return element;
		  
	  }
	  
	  public static WebElement totalNumberOfSearch(WebDriver driver){
		  element = driver.findElement(By.xpath("//div[@class='KG9X1F']//span[4]"));
		  return element;
		  
	  }
	  
	  public static List<WebElement> totalItems(WebDriver driver){		  
		  elements = driver.findElements(By.xpath("//div[@class='col zZCdz4']"));	  
		  return elements;
		  
	  }
      
	  public static List<WebElement> totalPriceOfItems(WebDriver driver){
    	  elements = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
    	  return elements;
    	  
      }
	  
	  public static List<WebElement> div_addToCompare(WebDriver driver){
		  elements = driver.findElements(By.xpath("//div[@class='_2kFyHg']"));
		  return elements;
		  
	  }
	  
	  public static WebElement butn_compare(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[text()='COMPARE']"));
		  return element;
		  
	  }
 }
