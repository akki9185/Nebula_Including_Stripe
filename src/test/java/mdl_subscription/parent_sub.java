package mdl_subscription;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Base.BaseInt;

public class parent_sub extends BaseInt{
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	
	@BeforeSuite
	public void start() throws IOException {
		startup();
	}
	
	
	@AfterSuite
	public void end() {
		driver.close();
		
	}
	
	
	
	

	
	
	
	
	
	
	
	public static void free_SubSelect(String subname) throws InterruptedException, IOException {
		try {			
		isElementPresent("sub", "subcard_Free_xpath").click();
		String subClss = isElementPresent("sub", "subcard_Free_xpath").getAttribute("class");
		wait.until(driver -> subClss.contains("mui-17cl4xt"));
		Assert.assertTrue(isElementPresent("sub", "subcard_Free_xpath").getAttribute("class").contains(getValue("sub", "subCardActiv")));		
		isElementPresent("sub", "ECgoal_xpath").click();
		validateGoal(subname,"EC",true);
		isElementPresent("sub", "GCgoal_xpath").click();
		validateGoal(subname,"GC",false);
		isElementPresent("sub", "FCgoal_xpath").click();
		validateGoal(subname,"FC",false);
		isElementPresent("sub", "PMgoal_xpath").click();
		validateGoal(subname,"PM",false);
		String tileClass = isElementPresent("sub", "subcard_Free_xpath").getAttribute("class");
		Assert.assertTrue(tileClass.contains("mui-17cl4xt"));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void validateGoal1(String subname,String goalName, boolean shouldBeSelected) throws IOException {
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	public static void validateGoal(String subname,String goalName, boolean shouldBeSelected) throws IOException {
		try {		
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
		catch (Exception e) {
			System.out.println(e);
		}
	    
	}
	
	
}
