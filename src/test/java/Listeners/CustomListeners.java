package Listeners;

import java.io.IOException;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;
import org.testng.Reporter;

import testBase.BaseClass;

public class CustomListeners implements ITestListener						
{		

   	
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

   
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

 	
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

  	
   /* public void onTestFailure(ITestResult arg0) {
    	
    	System.setProperty("org.uncommons.reportng.escape-output", "false");
    	try {
			BaseClass.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Reporter.log("Caputring Screenshot");
		Reporter.log("<a target = \"_blank\" href="+ BaseClass.screenshotName +">Screenshot</a>");
		Reporter.log("<br>");
		//Reporter.log("<a target = \"_blank\" href="+ BaseClass.screenshotName +">"+ "<img src=href="+ BaseClass.screenshotName +" height=200 width=200></img></a>");				
		Reporter.log("<a target=\"_blank\" href=\"" + BaseClass.screenshotName + "\">" + "<img src=\"" + BaseClass.screenshotName + "\" height=\"200\" width=\"200\"></img></a>");
		
    }	*/	

   
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

  	
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

	
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
}		
