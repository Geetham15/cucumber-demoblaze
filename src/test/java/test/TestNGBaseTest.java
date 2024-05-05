package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;

public class TestNGBaseTest {
	Common common;
	public static WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browser, String url) {
		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
