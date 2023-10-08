package testCases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_002_AddCustomerLoginTest extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void addCustomer(String firstname,String lastname,String postcode,String alerttext) 
	{
	     	try 
	     	{
			driver.findElement(By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg")).click();
			logger.info("Clicked on Bank Manager Login button");
			
			
			driver.findElement(By.xpath("//button[@ng-click=\"addCust()\"]")).click();
			
			WebElement txtFirstname = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
			txtFirstname.clear();
			txtFirstname.sendKeys(firstname);
			
			
			WebElement txtLastname = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
			txtLastname.clear();
			txtLastname.sendKeys(lastname);
			
			WebElement  txtPostCode =  driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]"));
			txtPostCode.clear();
			txtPostCode.sendKeys(postcode);
			

			 driver.findElement(By.xpath("//button[@type=\"submit\"]")).click(); //add customer button
			 
			// WebDriverWait wait = new WebDriverWait(driver, 5); // Create WebDriverWait object with a timeout of 5 seconds
			// Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	         Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        
			  Assert.assertTrue(alert.getText().contains(alerttext));

			    alert.accept();
		 }
	     	catch(Exception e)
		  {
	     		 Assert.fail("Customer not added successfully");
		  }
		
		
		 
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		String path=".\\testData\\AddCustomers_LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}

}