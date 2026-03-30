package Z_Dummy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;

import BaseClass.BaseInt;

public class JavaClass extends BaseInt{
	
	public static int dfltseat ;
	
	

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		startup();
		driver.get(getValue("sub", "url"));
		selectSub("Basic", "slct", 5);
//		selectSub("Basic", "dslct", 1);	
		
		
		
		
		
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	public static void selectSub(String subname, String action, int seat) throws IOException {
		WebElement sub = driver.findElement(By.xpath("//h5[contains(text(),'Subscription - "+ subname +"')]/ancestor::div[contains(@class,'MuiCard-root')]"));
		String classes = sub.getAttribute("class");
		String aftrclick = "";
		System.out.println(classes);
		if(classes.contains("mui-8gjtj4") ||  action.equalsIgnoreCase("slct")) { //Plan not selected
			sub.click();
			aftrclick = sub.getAttribute("class");
			System.out.println(aftrclick);
			Assert.assertTrue(aftrclick.contains("mui-1c9w84k"), "Class is Alredy selected");
			System.out.println("Plan selected");
			WebElement Seattype = sub.findElement(By.xpath(getValue("sub", "RO")));
			for(int i = 0; i<seat;i++) {
				Seattype.findElement(By.xpath(getValue("sub", "incre"))).click();
			}
			
			
			
			
			
			
			
			}
//		else if(classes.contains("mui-1c9w84k") || action.equalsIgnoreCase("dslct")) {
//			sub.click();
//			aftrclick = sub.getAttribute("class");
//			System.out.println(aftrclick);  
//			Assert.assertTrue(aftrclick.contains("mui-8gjtj4"), "Class is Alredy selected");
//			System.out.println("Plan Deselected");
//		  	}
//		
//		WebElement Seattype = sub.findElement(By.xpath(getValue("sub", "RO")));
//		System.out.println(Seattype);
//		for(int i = 0; i<seat;i++) {
//			Seattype.findElement(By.xpath(getValue("sub", "incre"))).click();
//		}
//		
		
				
		
	
		  
		  
		  
		  }
	


	
}
