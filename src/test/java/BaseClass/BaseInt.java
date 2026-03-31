package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseInt {
	
	public static WebDriver driver;	
	
	
	public static void startup() throws IOException {
		if(getValue("commn", "browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(getValue("commn", "browser").equalsIgnoreCase("fire")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	
	public static WebElement isElementPresent(String filename, String prokey) throws IOException {
		  String locatorValue = getValue(filename, prokey);
		
		if(prokey.contains("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		}
		if(prokey.contains("id")) {
			return driver.findElement(By.id(locatorValue));
		}
		if(prokey.contains("linktxt")) {
			return driver.findElement(By.linkText(locatorValue));
		}
		if(prokey.contains("name")) {
			return driver.findElement(By.name(locatorValue));
		}
		
		return null;
		
	}
	
	

	public static List<WebElement> getElements(String fileName, String propKey) throws IOException {
	    String locatorValue = getValue(fileName, propKey);
	    
	    try {
	        if (propKey.contains("id")) {
	            return driver.findElements(By.id(locatorValue));
	        }
	        if (propKey.contains("xpath")) {
	            return driver.findElements(By.xpath(locatorValue));
	        }
	        if (propKey.contains("name")) {
	            return driver.findElements(By.name(locatorValue));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error finding elements for key: " + propKey);
	    }
	    
	    // Returns an empty list if the propKey doesn't match id, xpath, or name
	    return new java.util.ArrayList<WebElement>();
	}

	
	//Properties Centralize method
	private static Map<String, Properties> propertyMap = new HashMap<>();
	public static Properties loadProperty(String fileName) throws IOException {
		if (propertyMap.containsKey(fileName)) {
		        return propertyMap.get(fileName);
		    }
	    Properties propt = new Properties();
	    try (FileInputStream fi = new FileInputStream("./src/test/java/Properties/" + fileName + ".properties")) {
	        propt.load(fi);
	    }
        propertyMap.put(fileName, propt);

	    return propt;
	}
	
	public static String getValue(String fileName, String key) throws IOException {
	    Properties prop = loadProperty(fileName);
//	    System.out.println(loadProperty(fileName));
	    return prop.getProperty(key).trim();
	}
	
	

	
	

}
