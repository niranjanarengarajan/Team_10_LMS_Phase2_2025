package com.runners;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = { "src/test/resources/Features/test.feature" }, // location of feature files
		glue = { "com.hooks", "com.stepDefinitions" }, monochrome = true, dryRun = false, plugin = {
				"rerun:failed_scenarios/failed_scenarios.txt",

				"com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
				"html:target/cucumber-reports/reports.html", "html:test-output/index.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
