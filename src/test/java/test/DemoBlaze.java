package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze extends BaseTest {

	public void demoBlazeSignUp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement signInModalLink = driver.findElement(By.xpath("//a[@id='signin2']"));
		signInModalLink.click();
		WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
		WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
		WebElement signinusername = modalContentBody.findElement(By.id("sign-username"));
		signinusername.sendKeys("munisw");
		WebElement signinpassword = modalContentBody.findElement(By.id("sign-password"));
		signinpassword.sendKeys("munisw");

		WebElement modalSignUpAcceptButton = modalContainer.findElement(By.xpath(".//button[text()='Sign up']"));
		modalSignUpAcceptButton.click();
		
		//String message = driver.switchTo().alert().getText();
		//System.out.println("message = " + message);
		try {
			if(wait.until(ExpectedConditions.alertIsPresent())==null) {
				System.out.println("Alert not displayed");
			}else {
				String message = driver.switchTo().alert().getText();
				System.out.println("message = " + message);
				driver.switchTo().alert().accept();
			}
		}catch(NoAlertPresentException ne) {
			System.out.println("Alert not displayed");
			ne.printStackTrace();
		}
		
	}

	public void demoBlazeLogin() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login2']"))).click();
		WebElement loginModalLink = driver.findElement(By.xpath("//a[@id='login2']"));
		loginModalLink.click();
		WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
		WebElement modalContentBody = modalContainer.findElement(By.xpath(".//div[@class='modal-body']"));
		WebElement loginusername = modalContentBody.findElement(By.id("loginusername"));
		loginusername.sendKeys("geetha1");
		WebElement loginpassword = modalContentBody.findElement(By.id("loginpassword"));
		loginpassword.sendKeys("geetha1");

		WebElement modalLoginAcceptButton = modalContainer.findElement(By.xpath(".//button[text()='Log in']"));
		modalLoginAcceptButton.click();
		
		
		//WebElement promptAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign up successful')]"));
		// Actions act = new Actions(driver);
		// act.moveToElement(loginlink).build().perform();
	}

	public static void main(String[] args) {
		DemoBlaze db = new DemoBlaze();
		db.setupBrowser("firefox", "https://www.demoblaze.com");

		db.demoBlazeSignUp();
		// db.demoBlazeLogin();
	}

}
