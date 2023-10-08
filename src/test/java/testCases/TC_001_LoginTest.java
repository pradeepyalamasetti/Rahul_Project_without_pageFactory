package testCases;

import org.testng.Assert;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass{
	
	@Test
	public void loginAsbankManager() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_LoginTest ***");
		
		driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg")).click();
		logger.info("Clicked on Bank Manager Login button");
		
		
		driver.findElement(By.xpath("//button[@ng-click=\"addCust()\"]")).click();
		
	
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		
		//Adding Assertions
		//Assert.assertTrue(isElementPresent(By.xpath("//button[@ng-click=\"addCust()\"]")),"Login not successfully");
		
		boolean isElementDisplayed = isElementPresent(By.xpath("//button[@ng-click=\"addCust()\"]"));
		System.out.println("Element is present: " + isElementDisplayed);
		Assert.assertTrue(isElementDisplayed, "Login not successful");
		

		Thread.sleep(3000);
		
		logger.info("***  Finished TC_001_LoginTest ***");
	}


}