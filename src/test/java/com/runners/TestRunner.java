package com.runners;


import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features/ProgramAdd.feature"}, //location of feature files
		glue= {"com.hooks","com.stepdefinitions"},
		monochrome=true
			
		
		/*plugin = { 
		"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", 
		"html:target/cucumber-reports/reports.html", 
		"html:test-output/index.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
		
		dryRun = false, */
		
		)
		 

public class TestRunner extends AbstractTestNGCucumberTests{


}

