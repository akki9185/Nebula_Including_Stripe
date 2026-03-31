package mdl_subscription;

import static org.testng.Assert.assertEquals;
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
			String bgclr = "";
			String newbgclr = "";
			
//			Thread.sleep(1000);
			bgclr = subs.getCssValue("background-color");
			System.out.println(bgclr);
			subs.click();
			Thread.sleep(2000);
			//wait.until(driver ->!subs.getCssValue("background-color").equals(bgclr));
			newbgclr = subs.getCssValue("background-color");
			System.out.println(newbgclr);	
			assertEquals(newbgclr, getValue("sub", "blueclr"),">>>>>>>>>>####################");		
			validateGoal(subname,"EC",true);
			validateGoal(subname,"FC",false);
			validateGoal(subname,"GC",false);
			validateGoal(subname,"PM",false);
			
			
			
			
			
//			//assertEquals(goalFC.getCssValue("background-color"), getValue("sub", "white"), "FC is selected But Subscriptin is not.");
//			//validateGoal("FC",false);
//			assertEquals(goalGC.getCssValue("background-color"), getValue("sub", "white"), "GC is selected But Subscriptin is not.");
//			assertEquals(goalPM.getCssValue("background-color"), getValue("sub", "white"), "PM is selected But Subscriptin is not.");
//			
//			assertEquals(goalEC.getCssValue("background-color"), getValue("sub", "blueclr"), "EC is not selected Default with Subscription selected");
//			goalGC.click();
//			assertEquals(goalGC.getCssValue("background-color"), getValue("sub", "blueclr"), "GC is not selected Default with Subscription selected");
//			goalFC.click();
//			assertEquals(goalFC.getCssValue("background-color"), getValue("sub", "blueclr"), "FC is not selected Default with Subscription selected");
//			goalPM.click();
//			assertEquals(goalPM.getCssValue("background-color"), getValue("sub", "blueclr"), "PM is not selected Default with Subscription selected");
//			if(newbgclr.contains(getValue("sub", "blueclr"))) {
//				subs.click();
//				Thread.sleep(2000);
//				String aa = subs.getCssValue("background-color");
////				wait.until(driver -> !aa.equals(newbgclr));
//				System.out.println(subs.getCssValue("background-color") +" >>>>>>>>>>>>>>>>>>>> Subscription>>>>>>>"  + getValue("sub", "white"));
//				assertEquals(subs.getCssValue("background-color"), aa, "Subscription is not Deselected when click");
//				System.out.println(goalEC.getCssValue("background-color") +" >>>>>>>>>>>>>>>>>>>> Goal >>>>>>>"  + getValue("sub", "white"));
//				assertEquals(goalEC.getCssValue("background-color"), getValue("sub", "white"), "EC is Not Deselected when Subscription Deselect.");		
//			}
//			
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

	    String expectedColor = shouldBeSelected 
	            ? getValue("sub", "blueclr") 
	            : getValue("sub", "white");

	    if(shouldBeSelected) {
	        Assert.assertTrue(actualColor.contains(expectedColor),
	                goalName + " should be selected but is NOT");
	    } else {
	        Assert.assertTrue(actualColor.contains(expectedColor),
	                goalName + " should NOT be selected but it IS");
	    }
	}
}
