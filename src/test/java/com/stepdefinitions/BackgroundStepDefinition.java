package com.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.driverManager.DriverFactory;
import com.pages.ClassPages;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.LoggerLoad;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BackgroundStepDefinition {
    private WebDriver driver;
    private ClassPages classPage;

    public BackgroundStepDefinition() {
        this.driver = DriverFactory.getDriver();
        this.classPage = new ClassPages(driver);
    }


//	@Before("@ProgramLogin")
//	public void logInLMSPortal()
//	{
//		//LoginPage login = new LoginPage(DriverFactory.getDriver());
//		//login.enterLoginDetails();
//	}
//	
//	
//	
//	@Given("The Browser is open")
//	public void the_browser_is_open() {
//		LoginPage login=new LoginPage(DriverFactory.getDriver());
//		login.enterLoginDetails();
//	  
//	}
//
//	@When("Log into LMS Portal as Admin")
//	public void log_into_lms_portal_as_admin() {
//	
//	}
	
	  @When("Admin clicks the Class Navigation bar in the Header")
	    public void admin_clicks_the_class_navigation_bar_in_the_header() {
	        LoggerLoad.logInfo("Admin clicks the Class Navigation bar in the Header");
	        classPage.clickClass();
	    }

	
	
	
}
