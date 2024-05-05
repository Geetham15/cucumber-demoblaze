package test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicValidation extends TestNGBaseTest {

	@Test
	public void titleValidation() {
		String expectedResult = "STORE";
		String actualResult = driver.getTitle();
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page title,");
	}
	
	@Test
	public void urlValidation() {
		String expectedResult = "https://www.demoblaze.com/";
		String actualResult = driver.getCurrentUrl();
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the page URL,");
	}
}
