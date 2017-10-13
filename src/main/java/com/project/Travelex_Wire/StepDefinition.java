package com.project.Travelex_Wire;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition {
	private static final String ExpectedMessage = null;
	private static final String ActualMessage = null;
	public WebDriver driver;
	public int random;
	private PrintStream verificationErrors;

	@Given("^I am on the Homepage$")
	public void i_am_on_the_Homepage() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://wire.travelex.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Given("^I click sign up$")
	public void i_click_sign_up() throws Throwable {
		driver.findElement(By.cssSelector("body > app > ui-view > tvx-landing > div > header > div > div.button-wrap > a.account-action.sign-up")).click();
	}

	@Given("^I enter all the sign up detail$")
	public void i_enter_all_the_sign_up_detail() throws Throwable {
		driver.findElement(By.name("firstName")).sendKeys("Mercie");
		driver.findElement(By.name("lastName")).sendKeys("John");
		
		random = 100 + (int)(Math.random() * ((1000 - 1) + 1));
		System.out.println(random);
		driver.findElement(By.name("email")).sendKeys("maxwell" + random + "@yahoo.com");
		Thread.sleep(1000);
		
		driver.findElement(By.name("birthdate")).sendKeys("02/10/1992");
		driver.findElement(By.id("mobile")).sendKeys("0737545750");
		driver.findElement(By.id("password")).sendKeys("Monday&1");
		driver.findElement(By.cssSelector("#agreeTerms > div.md-container.md-ink-ripple")).click();
		
	}

	@When("^I click on the Register link$")
	public void i_click_on_the_Register_link() throws Throwable {
		driver.findElement(By.cssSelector("body > app > ui-view > onboarding > ui-view > register > div > div.Onboarding__content > div > div.Onboarding__form > tvx-register > form > div:nth-child(9) > button")).submit();  
	}

	@Then("^my acount is created$")
	public void my_acount_is_created() throws Throwable {
		String ExpectedMessage = "You haven't made your first payment yet"; 
		String ActualMessage = driver.findElement(By.cssSelector("body > app > ui-view > auth-view > ui-view > main > div > ui-view > order-summary > div > div.zero-records-container.tvx-baseline.ng-scope > h1")).getText();		
		System.out.println(ActualMessage);
		Assert.assertEquals(ExpectedMessage, ActualMessage);
	    
	}

	@Given("^I click the FAQ link$")
	public void i_click_the_FAQ_link() throws Throwable {
	   driver.findElement(By.cssSelector("#tvx-footer > footer > div.footer-logo-line > a:nth-child(2) > abbr")).click();
	}

	@Then("^I search for Answers$")
	public void i_search_for_Answers() throws Throwable {
	  driver.findElement(By.cssSelector("body > header > div > div > form > button")).sendKeys("What do I need to get started");
	}
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
			driver.quit();
			 
	}


}