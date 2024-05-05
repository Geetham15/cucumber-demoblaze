package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {
	
	private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		//if(browser.equalsIgnoreCase("chrome"))
		//	driver = new ChromeDriver();
		//else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		//else if(browser.equalsIgnoreCase("Edge"))
		//	driver = new EdgeDriver();
		//else if(browser.equalsIgnoreCase("safari"))
		//	driver = new SafariDriver();
		//else {
		//	System.out.println("valid browser is not provided, hence quiting this automation run.");
		//	System.exit(0);
		//}
		openUrl(url);			
	}
	
	public void openUrl(String url) {
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");	
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeTab() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
}
