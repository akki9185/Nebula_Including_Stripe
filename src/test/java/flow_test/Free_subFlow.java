package flow_test;

import java.io.IOException;

import org.testng.Assert;

import Base.BaseInt;
import mdl_subscription.parent_sub;

public class Free_subFlow extends BaseInt{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		try {
		
		startup();
		driver.get("http://206.189.23.26:3003/webapp/subscription");
		parent_sub.free_SubSelect("Free");
		isElementPresent("sub", "btn_crtaccnt_xpath").click();
		
		
		
//		
//		
//		loginLogout.login();
		
		Thread.sleep(3000);		
		}
		catch (Exception e) {
			System.out.println("+++++++++++++++++"+e+ "+++++++++++++++++");
		}
		
		
		
		

	}

}
