package mdl_subscription;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	
	
	
	public  void selectplan(String subname) throws InterruptedException, IOException {
		WebElement subs = driver.findElement(By.xpath("//h5[contains(text(),'Subscription - "+ subname +"')]/ancestor::div[contains(@class,'MuiCard-root')]"));
		WebElement goal = driver.findElement(By.xpath("//p[contains(text(), 'EC')]/parent::div"));
		System.out.println(goal);
		subs.click();
		Thread.sleep(1000);
		String bgclr = subs.getCssValue("background-color"); 
		System.out.println(bgclr);
		assertEquals(bgclr, getValue("sub", "blueclr"));
		assertEquals(goal.getCssValue("background-color"), getValue("sub", "blueclr"));	
		if(bgclr.contains(getValue("sub", "blueclr"))) {
			subs.click();
			Thread.sleep(1000);
			assertEquals(bgclr, getValue("sub", "white"));	
			assertEquals(goal.getCssValue("background-color"), getValue("sum", "white"));			
		}
		
		
		
		}
	
	

}
