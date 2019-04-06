package com.stepdef;

import java.util.concurrent.TimeUnit;

import com.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class StepDef {
	
	private WebDriver driver;
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

	@Given("user launching {string}http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=3153377 broswer and open {string} app")
	public void user_launching_broswer_and_open_app(String browser,String url) {
		if(browser.equalsIgnoreCase("IE")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("Chrome")){

		}
		else{

		}
	}
	
	

	@When("user click on {string} button on {string} screen")
	public void user_click_on_button_on_screen(String string, String string2) {
	    	driver.findElement(webDriverUtils.getBy(string)).click();
	    }

	@Then("user type {string} on {string} in {string} screen")
	public void user_type_on_in_screen(String string, String string2, String string3) {
		driver.findElement(webDriverUtils.getBy(string)).sendKeys(string2);
	}

	@Then("user select {string} on {string} in {string} screen")
	public void user_select_on_in_screen(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		new Select(driver.findElement(webDriverUtils.getBy(string))).selectByVisibleText(string2);
	    throw new cucumber.api.PendingException();
	}

	@Then("user hover on {string} and click on {string} on {string} screen")
	public void user_hover_on_and_click_on_on_screen(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}




}
