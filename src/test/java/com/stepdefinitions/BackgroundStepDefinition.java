package com.stepdefinitions;

import com.driverManager.DriverFactory;
import com.pages.ClassPageValidation;
import com.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStepDefinition {

//	@Before("@login")
//	public void logInLMSPortal()
//	{
//		System.out.println("I am inside @login annotation");
//		LoginPage login = new LoginPage(DriverFactory.getDriver());
//		login.enterLoginDetails();
//	}
//	
	
	
	@Given("The Browser is open")
	public void the_browser_is_open() {
		System.out.println("I am inside background given ");
	}
	@When("Log into LMS Portal as Admin")
	public void log_into_lms_portal_as_admin() {
		System.out.println("I am inside background when");
			LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.enterLoginDetails();
	}
	@Then("Admin should land on the Manage Class page")
	public void admin_should_land_on_the_manage_class_page() {
		ClassPageValidation cpv= new ClassPageValidation(DriverFactory.getDriver());
		cpv.classClick();
	}
	
}
