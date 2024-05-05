package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	WebDriver driver; // Instance
	
	public void setupBrowser(String browser, String url) {
		//opening the browser
		if(browser.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else {
			System.out.println("valid browser is not provided, hence quitting this automation run.");
			System.exit(0);
		}
		//maximize the window
		//driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //normally 10 sec in dev and 3 sec in production
		
		
		//page load timeout ==> pom
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		// script load timeout ==> usually defined in setup browser method or pom
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		//opening the url
		if(url!="")
			driver.get(url);
			//driver.get("https://www.facebook.com"); //url always starts with http or https 
			//in companies --- http://192.168.1.55/appname 
		else
			driver.get("about:blank");
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	public static void main(String[] args) {
		BaseTest obj = new BaseTest();
		obj.setupBrowser("chrome","https://www.facebook.com");	
		//obj.setupBrowser("chrome","");	
		//obj.quitBrowser();
	}

}
