package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger; // for logging

	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String browse)
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		//launch right browser based on parameter
		if (browse.equals("chrome")) 
		   {
			driver = new ChromeDriver();
		   } 
		else if (browse.equals("edge"))
		   {
			driver = new EdgeDriver();
		   } 
		else 
		   {
			driver = new ChromeDriver();
		   }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		//driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/manager");
		driver.manage().window().maximize();
		
	}
	
	
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;

	}
	
	/*public static String screenshotPath;
	public static String screenshotName;
	
	
	public static String  captureScreenshot() throws IOException 
	{	
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		//screenshotName = "error.jpg";
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		String destination = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;
		
		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;

	}*/

}
 
