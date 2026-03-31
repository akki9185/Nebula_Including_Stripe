package Z_Dummy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseInt;

public class SelectSubWithGoal  extends BaseInt{
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		startup();
		driver.get(getValue("sub", "url"));
		  
		WebElement free = driver.findElement(By.xpath("//h5[contains(text(),'Subscription - Free')]/ancestor::div[contains(@class,'MuiCard-root')]"));
		String bgclr =  free.getCssValue("background-color");
		free.click();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(driver -> !free.getCssValue("background-color").equals(bgclr));
		assertEquals(isElementPresent("sub", "btn_blueEC_xpath").getCssValue("background-color"), getValue("sub", "blueclr"), "color is not same");
		free.click();
		wait.until(driver -> free.getCssValue("background-color").equals(bgclr));
		assertEquals(isElementPresent("sub", "btn_blueEC_xpath").getCssValue("background-color"), bgclr, "color is not same");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		Thread.sleep(2000);
//		driver.close();
		
		
		
		
	}
	

}
