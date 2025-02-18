package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"}, //location of feature files
		glue= {"com.stepdefenitions"},

			
		
		plugin = { 
		"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", 
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports/reports.html", 
		"html:test-output/index.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
		
		dryRun = false, 
		monochrome=true
		)
		 

public class TestRunner{


}

