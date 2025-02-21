package com.runners;

import io.cucumber.testng.CucumberOptions;


import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = {"src/test/resources/Features"}, //location of feature files
		glue= {"com.hooks","com.stepdefinitions"},
		monochrome=true,
        dryRun = false, 
		plugin = { 

		"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", 
		"html:target/cucumber-reports/reports.html", 
		"html:test-output/index.html"
		},
		publish =true
		)
public class TTestRunner extends AbstractTestNGCucumberTests {

}
