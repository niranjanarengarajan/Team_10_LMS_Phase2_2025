package com.stepdefinitions;

import org.testng.Assert;

import com.driverManager.DriverFactory;
import com.pages.ProgramPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramStepDefinition {
	
	ProgramPage programObject=new ProgramPage(DriverFactory.getDriver());
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
	    
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   
		programObject.clickNavigationBar(string);
	}

	@Then("Admin should be navigated to {string} page")
	public void admin_should_be_navigated_to_program_page(String string) {
		boolean result = programObject.validate_navbar_pagenav(string);
		Assert.assertTrue(result);
	}
}
