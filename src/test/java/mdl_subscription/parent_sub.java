package mdl_subscription;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import BaseClass.BaseInt;

public class parent_sub extends BaseInt{
	
	
	@BeforeSuite
	public void start() throws IOException {
		startup();
	}
	
	
	@AfterSuite
	public void end() {
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	public static void selectplanonebyone(String subname) throws InterruptedException, IOException {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement subs = driver.findElement(By.xpath("//h5[contains(text(),'Subscription - "+ subname +"')]/ancestor::div[contains(@class,'MuiCard-root')]"));
			WebElement goalEC = isElementPresent("sub", "btn_blueEC_xpath");
			WebElement goalGC = isElementPresent("sub", "btn_GC_xpath"); 
			WebElement goalFC = isElementPresent("sub", "btn_FC_xpath");
			WebElement goalPM = isElementPresent("sub", "btn_PM_xpath");
			String bgclr = subs.getCssValue("background-color");
			String newbgclr = "";
			
//			Thread.sleep(1000);
			 
			System.out.println(bgclr + "++++++++++++++++++");
			subs.click();
//			Thread.sleep(3000);
			wait.until(driver -> !subs.getCssValue("background-color").equals(bgclr));
			newbgclr = subs.getCssValue("background-color");
			System.out.println(newbgclr + "----------------");	
 			//assertEquals(newbgclr, getValue("sub", "blueclr"),">>>>>>>>>>####################");
 			Assert.assertTrue(newbgclr.contains("36, 98, 255, 1"));
			validateGoal(subname,"EC",true);
			validateGoal(subname,"FC",false);
			validateGoal(subname,"GC",false);
			validateGoal(subname,"PM",false);
			
			if(subname.equalsIgnoreCase("Free"))
			{
				goalEC.click();
				validateGoal(subname,"EC",true);
				goalGC.click();
				validateGoal(subname,"GC",false);
				goalFC.click();
				validateGoal(subname,"FC",false);
				goalPM.click();
				validateGoal(subname,"PM",false);
			}
			else if(subname.equalsIgnoreCase("Basic")){			
//				goalEC.click();
				validateGoal(subname,"EC",true);
				goalGC.click();
				Thread.sleep(1000);
				validateGoal(subname,"GC",true);
				goalFC.click();
				Thread.sleep(1000);
				validateGoal(subname,"FC",true);
				goalPM.click();
				Thread.sleep(1000);
				validateGoal(subname,"PM",true);
				
			}
			else {
				validateGoal(subname,"EC",true);
				Thread.sleep(1000);
				validateGoal(subname,"FC",true);
				validateGoal(subname,"GC",true);
				validateGoal(subname,"PM",true);
			}
			}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("Selection issue  >>>>>>>>>>>>>>>>>");
			}		
		}
	
	
	
	
	public static void validateGoal(String subname,String goalName, boolean shouldBeSelected) throws IOException {
		
	    By goalLocator = By.xpath("//p[contains(text(), '"+goalName+"')]/parent::div");
	    WebElement goal = driver.findElement(goalLocator);
	    String actualColor = goal.getCssValue("background-color");
	    String opacity  = goal.getCssValue("opacity");
	    if(subname.equalsIgnoreCase("Free") && !goalName.equalsIgnoreCase("EC")) {
	    	//assertTrue(goal.getCssValue("opacity"),
	    	Assert.assertEquals(opacity, "0.45", "Expected opacity 0.45 for Free plan but found:");
	    }
	    String expectedColor = shouldBeSelected ? getValue("sub", "blueclr") : getValue("sub", "white");
	    if (shouldBeSelected) {
	        Assert.assertTrue(actualColor.contains(expectedColor),
	            goalName + " should be selected but is NOT");
	        System.out.println("True &&&&&&&&&&&" + actualColor + expectedColor + subname + goalName+ shouldBeSelected );

	    } else {
	        Assert.assertTrue(actualColor.contains(expectedColor),
	            goalName + " should NOT be selected but is correct");
	        System.out.println("False &&&&&&&&&&&" + actualColor + expectedColor + subname + goalName+ shouldBeSelected );

	    }
	    
	}
	
	public static void selectFree() {
		
		
	}
}
