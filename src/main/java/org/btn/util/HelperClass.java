package org.btn.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HelperClass {
	
	private static HelperClass helperClass;
    
    private static WebDriver driver;
    public final static int TIMEOUT = 5;
       
	@SuppressWarnings("deprecation")
	private HelperClass() {
		System.setProperty("webdriver.chrome.driver","src\\test\\driver\\chromedriver.exe");
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
     }      
               
	public static void openPage(String url) {
        driver.get(url);
    }
           
    public static WebDriver getDriver() {
        return driver;              
    }
       
    public static void setUpDriver() {
           
        if (helperClass==null) {
               
            helperClass = new HelperClass();
        }
    }
       
    public static void tearDown() {
    	
        if(driver!=null) {
             driver.close();
             driver.quit();
        }
            
       helperClass = null;
   } 
}
