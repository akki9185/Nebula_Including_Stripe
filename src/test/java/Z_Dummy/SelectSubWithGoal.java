package Z_Dummy;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseInt;

public class SelectSubWithGoal  extends BaseInt{
	
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static String bgclr ;
	public static String newbgclr ;

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		startup();
		driver.get(getValue("sub", "url"));
		String sublist = getValue("sub", "sublist");
		List<String> aa = Arrays.asList(sublist.split(","));
		System.out.println(aa);
		for(int i = 0; i< aa.size();i++) {
			System.out.println(aa.get(i).trim());
			selectFree(aa.get(i).trim());
		}	
		Thread.sleep(2000);
		driver.close();
	}	
	
	
	
	
	
	//Select Free and Validation EC is Selected and Other is Disable
	public static void selectFree(String subname) throws IOException {
		if(subname.equalsIgnoreCase("Free")) {
			try {
			WebElement sfree = isElementPresent("sub", "sub_Free_xpath");
			bgclr = sfree.getCssValue("background-color");
			sfree.click();
			Thread.sleep(2000);
	//		wait.until(driver -> !sfree.getCssValue("background-color").equals(bgclr));
			newbgclr = sfree.getCssValue("background-color");
			Assert.assertTrue(newbgclr.contains("36, 98, 255, 1"));
			validateGoal("Free","EC",true);
			validateGoal("Free","FC",false);
			validateGoal("Free","GC",false);
			validateGoal("Free","PM",false);
			isElementPresent("sub", "btn_EC_xpath").click();
			validateGoal("Free","EC",true);
			isElementPresent("sub", "btn_GC_xpath").click();
			validateGoal("Free","GC",false);
			isElementPresent("sub", "btn_FC_xpath").click();
			validateGoal("Free","FC",false);
			isElementPresent("sub", "btn_PM_xpath").click();
			validateGoal("Free","PM",false);
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Selection issue in Free subscription.");
			}
		}
		else if(subname.equalsIgnoreCase("Basic")) {
			try {
				WebElement sBasic= isElementPresent("sub", "sub_Basic_xpath");
				bgclr = sBasic.getCssValue("background-color");
				sBasic.click();
				Thread.sleep(2000);
				Assert.assertTrue(isElementPresent("sub", "sub_Free_xpath").getCssValue("background-color").equals(getValue("sub", "white")));
//				wait.until(driver -> !sBasic.getCssValue("background-color").equals(bgclr));
				newbgclr = sBasic.getCssValue("background-color");
				Assert.assertTrue(newbgclr.contains("36, 98, 255, 1"));
				validateGoal("Basic","EC",true);
				validateGoal("Basic","FC",false);
				validateGoal("Basic","GC",false);
				validateGoal("Basic","PM",false);
				isElementPresent("sub", "btn_EC_xpath").click();
				Thread.sleep(1000);
				validateGoal("Basic","EC",true);
				isElementPresent("sub", "btn_GC_xpath").click();
				Thread.sleep(1000);
				validateGoal("Basic","GC",true);
				isElementPresent("sub", "btn_FC_xpath").click();
				Thread.sleep(1000);
				validateGoal("Basic","FC",true);
				isElementPresent("sub", "btn_PM_xpath").click();
				Thread.sleep(1000);
				validateGoal("Basic","PM",true);	
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Selection issue in Basic subscription.");
			}			
		}
		else {
			if(subname.equalsIgnoreCase("Professional")) {
				isElementPresent("sub", "").click();
				Assert.assertTrue(isElementPresent("sub", "sub_Basic_xpath").getCssValue("background-color").equals(getValue("sub", "white")));
			}
			if(subname.equalsIgnoreCase("Enterprise")) {
				isElementPresent("sub", "").click();
				Assert.assertTrue(isElementPresent("sub", "sub_Pro_xpath").getCssValue("background-color").equals(getValue("sub", "white")));
			}
			validateGoal("Free","EC",true);
			validateGoal("Free","FC",true);
			validateGoal("Free","GC",true);
			validateGoal("Free","PM",true);
			
			
			
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

	
	
	
	

}
