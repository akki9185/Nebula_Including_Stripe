package Z_Dummy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseInt;

public class JavaClass extends BaseInt{
	
	public static int dfltseat ;
	
	

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		startup();
		driver.get(getValue("sub", "url"));
		String sublist = getValue("sub", "sublist");
		List<String> aa = Arrays.asList(sublist.split(","));
		System.out.println(aa);
		for(int i = 0; i< aa.size();i++) {
			System.out.println(aa.get(i).trim());
			selectplan(aa.get(i).trim());
		}
		
		
//		selectplan("Basic");
		
		
		
		
		
//		Thread.sleep(3000);
//		driver.close();
	}
	
	
	
	public static void selectplan(String subname) throws InterruptedException, IOException {
		try {
			WebElement subs = driver.findElement(By.xpath("//h5[contains(text(),'Subscription - "+ subname +"')]/ancestor::div[contains(@class,'MuiCard-root')]"));
			WebElement goal = driver.findElement(By.xpath("//p[contains(text(), 'EC')]/parent::div"));		
//			Thread.sleep(1000);
			String bgclr = subs.getCssValue("background-color");
			System.out.println(bgclr);
			subs.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(driver ->!subs.getCssValue("background-color").equals(bgclr));
			String newbgclr = subs.getCssValue("background-color");
			System.out.println(newbgclr);		
			assertEquals(newbgclr, getValue("sub", "blueclr"));
			assertEquals(goal.getCssValue("background-color"), getValue("sub", "blueclr"));	
			if(newbgclr.contains(getValue("sub", "blueclr"))) {
				subs.click();
				Thread.sleep(1000);
				String aa = subs.getCssValue("background-color");
				wait.until(driver -> !aa.equals(newbgclr));
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				assertEquals(subs.getCssValue("background-color"), getValue("sub", "white"));
				System.out.println(goal.getCssValue("background-color") +" >>>>>>>>>>>>>>>>>>>>"  + getValue("sub", "white"));
				assertEquals(goal.getCssValue("background-color"), getValue("sub", "white"));		
			}
			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("Selection issue  >>>>>>>>>>>>>>>>>  ");
			}
			
		
				
		
	
		  
		  
		  
		  }
	


	
}
