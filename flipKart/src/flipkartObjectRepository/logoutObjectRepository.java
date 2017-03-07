package flipkartObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logoutObjectRepository {
	private static WebElement element = null;
	
	
	public static WebElement butn_Logout(WebDriver driver){
		element=driver.findElement(By.xpath("//*[@class='_2k0gmP']"));
		return element;
	}
}
