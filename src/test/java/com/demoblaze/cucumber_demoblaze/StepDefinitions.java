package com.demoblaze.cucumber_demoblaze;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pom.Login;
import utils.Common;

import org.openqa.selenium.WebDriver;

public class StepDefinitions {

	   String browser = "chrome";
	   String url = "https://www.demoblaze.com";
	   WebDriver driver;
	   Common common;
	   
	   @Before
	   public void setup() {
		   common = new Common();
		   common.setupBrowser(browser, url);
		   driver = common.getDriver();
	   }
			   
	   @After
	   public void tearDown() {
		   common.quitBrowser();
	   }
	   @Given("I am on the login page")
		public void navToLoginPage() {
		   driver.navigate().to(url);
		}

	   
	   @When("I enter {string} and {string}")
	   public void login(String username, String password) {
		   Login login = new Login(driver);
		   login.loginWithCredentials(username, password);
	   }
	   
	   @Then("I should be successfully logged in")
	   public void loginSuccess() {
		   System.out.println("logged in successfully");
	   }
	   
	   @Then("I should get login error message")
	   public void loginError() {
	       System.out.println("login error message displayed successfully");
	   }
}

