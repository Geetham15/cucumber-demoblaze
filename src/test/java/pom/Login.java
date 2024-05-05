package pom;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
	WebDriver driver;
	
	public Login(WebDriver driverObj) {
		driver = driverObj;
	}

	public void loginWithCredentials(String username, String password) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login2']"))).click();
		WebElement loginModalLink = driver.findElement(By.xpath("//a[@id='login2']"));
		loginModalLink.click();
		WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
		WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
		WebElement loginusername = modalContentBody.findElement(By.id("loginusername"));
		loginusername.sendKeys(username);
		WebElement loginpassword = modalContentBody.findElement(By.id("loginpassword"));
		loginpassword.sendKeys(password);

		WebElement modalLoginAcceptButton = modalContainer.findElement(By.xpath(".//button[text()='Log in']"));
		modalLoginAcceptButton.click();
		
		String loggedinGreetings = driver.findElement(By.id("nameofuser")).getText();
		System.out.println("Welcome Greeting --> " + loggedinGreetings);
		
		
		//WebElement promptAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign up successful')]"));
		// Actions act = new Actions(driver);
		// act.moveToElement(loginlink).build().perform();
	}

}
