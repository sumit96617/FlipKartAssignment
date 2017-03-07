package flipkartObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjectRepository {
	
private static WebElement element = null;

  public static WebElement link_Login(WebDriver driver){	  
	element =  driver.findElement(By.xpath("//*[text()='Log In']"));  
	return element;
	  	  
  }
  
  public static WebElement txtbox_username(WebDriver driver){	  
	 element = driver.findElement(By.xpath("//*[@class='_2zrpKA']"));	
	 return element;
	  	  
  }
  
  public static WebElement txtbox_password(WebDriver driver){	  
	element = driver.findElement(By.xpath("//*[@class='_2zrpKA _3v41xv']"));	  
	return element;	  
  }
  
  public static WebElement button_Login(WebDriver driver){	  
	element =  driver.findElement(By.xpath("//div[@class='_1avdGP']"));	  
	 return element;	  
  }

  public static WebElement link_MyAccount(WebDriver driver){
	element =  driver.findElement(By.xpath("//a[contains(@href,'link=home_account')]"));
	 return element;
  }
  
  public static WebElement link_UpdateEmailMobile(WebDriver driver){
	element =  driver.findElement(By.xpath("//a[contains(@href,'accountemailupdate')]"));
	 return element;  
  }
  
  public static WebElement span_Email(WebDriver driver){
	element =  driver.findElement(By.className("saved-email"));
	 return element;
  }
  
  public static WebElement span_Mobile(WebDriver driver){
	element =  driver.findElement(By.className("saved-mobile"));
	 return element;
	  }
  
  public static WebElement div_HomeScreen(WebDriver driver){
	element = driver.findElement(By.xpath("//a[@href='/']"));
	return element;
	 }
}