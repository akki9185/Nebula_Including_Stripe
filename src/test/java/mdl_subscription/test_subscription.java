package mdl_subscription;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class test_subscription extends parent_sub {
	
	
	@Test(priority = 1)
	public void TC_01() throws InterruptedException, IOException {
		
		driver.get("http://206.189.23.26:3003/webapp/subscription");
		String sublist = getValue("sub", "sublist");
		List<String> aa = Arrays.asList(sublist.split(","));
		System.out.println(aa);
		for(int i = 0; i< aa.size();i++) {
			System.out.println(aa.get(i).trim());
			selectplanonebyone(aa.get(i).trim());
		}		
	}
	
	
	
	
	
	

}
