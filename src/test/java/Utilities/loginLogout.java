package Utilities;

import java.io.IOException;

//import org.apache.logging.log4j.Logger;

import Base.BaseInt;

public class loginLogout extends BaseInt {
	
	
//	private static final Logger log = LogUtil.getLogger(loginLogout.class);
	
	public static void login() throws IOException {
			isElementPresent("webcommon","ip_email_id").sendKeys(getValue("webcommon", "user"));
			isElementPresent("webcommon","ip_pass_id").sendKeys(getValue("webcommon", "pass"));
			isElementPresent("webcommon","btn_login_xpath").click();
//			LogUtil.info(log, "Login successful");
			System.out.println("Login successful");
		}
	
	
	public static void admlogin() throws IOException {
			isElementPresent("webcommon","ip_email_id").sendKeys(getValue("admpnl", "user"));
			isElementPresent("webcommon","ip_pass_id").sendKeys(getValue("admpnl", "pass"));
			isElementPresent("webcommon","btn_login_xpath").click();
//			LogUtil.info(log, "Super Admin Login successful");
			System.out.println("Login successful");
		}	
	
	
	
	public static void logout() throws IOException {
		isElementPresent("webcommon","btn_profile_xpath").click();
		isElementPresent("webcommon","btn_logout_xpath").click();
//		LogUtil.info(log, "Logout success");
		System.out.println("Logout success");
	}

}
