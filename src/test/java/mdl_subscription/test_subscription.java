package mdl_subscription;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_subscription extends parent_sub {
	
	
	@Test(priority = 1)
	public void checkallplanclickable() throws InterruptedException, IOException {
		driver.get("http://206.189.23.26:3003/webapp/subscription");
		selectplan("Basic");		
	}
	
	
	
	
	

}
