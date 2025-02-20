package com.runners;


import org.testng.annotations.*;

import com.driverManager.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features"}, //location of feature files
		glue= {"com.stepdefinitions"},

			
		
		plugin = { 
		"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", 
		"html:target/cucumber-reports/reports.html", 
		"html:test-output/index.html"
		}, 
		
		dryRun = false, 
		monochrome=true
		)
		 

public class TestRunner extends AbstractTestNGCucumberTests{
	  @BeforeClass
	    public void setUp() {
	        DriverFactory.initializeWebDriver();
	    }

	    @AfterClass
	    public void tearDown() {
	        DriverFactory.closeDriver();
	    }

}

