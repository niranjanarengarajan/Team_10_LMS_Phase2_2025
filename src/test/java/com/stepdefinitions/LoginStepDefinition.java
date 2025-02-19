package com.stepdefinitions;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	LoginPage login =new LoginPage(DriverFactory.getDriver());
	
	@Given("Admin  gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	    
	    throw new io.cucumber.java.PendingException();
	}


	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
	   
		login.enterLoginDetails();
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
	   
		boolean result =login.validateLoginfunction();
		Assert.assertTrue(result);
	    throw new io.cucumber.java.PendingException();
	}




}
