package com.stepdefinitions;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BackgroundStepDefinition {

	@Before("@ProgramLogin")
	public void logInLMSPortal()
	{
		//LoginPage login = new LoginPage(DriverFactory.getDriver());
		//login.enterLoginDetails();
	}
	
	
	
	@Given("The Browser is open")
	public void the_browser_is_open() {
	  
	}

	@When("Log into LMS Portal as Admin")
	public void log_into_lms_portal_as_admin() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.enterLoginDetails();
	}
}
