package com.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.utils.Utils;
import com.utils.WebDriverUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	private WebDriver driver;
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

	@Given("user launching {string} broswer and open {string} app")
	public void user_launching_broswer_and_open_app(String browser,String url) {
		if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		}
		else{

		}
	}
	
	

	@When("user click on {string} button on {string} screen")
	public void user_click_on_button_on_screen(String ele, String screen) {
			String element = new Utils().xmlParser(ele, screen);
	    	driver.findElement(webDriverUtils.getBy(element)).click();
	    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    }

	@Then("user type {string} on {string} in {string} screen")
	public void user_type_on_in_screen(String text, String ele, String screen) {
		String element = new Utils().xmlParser(ele, screen);
		driver.findElement(webDriverUtils.getBy(element)).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("user select {string} on {string} in {string} screen")
	public void user_select_on_in_screen(String text, String ele, String screen) {
		String element = new Utils().xmlParser(ele, screen);
	    new Select(driver.findElement(webDriverUtils.getBy(element))).selectByVisibleText(text);
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
	}

	@Then("user hover on {string} and click on {string} on {string} screen")
	public void user_hover_on_and_click_on_on_screen(String element1, String element2, String screen) {
		String ele1 = new Utils().xmlParser(element1, screen);
		String ele2 = new Utils().xmlParser(element2, screen);
		
		Actions builder = new Actions(driver);
		
		WebElement ele = driver.findElement(webDriverUtils.getBy(ele1));
		builder.moveToElement(ele).click(driver.findElement(webDriverUtils.getBy(ele2))).build().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}




}
