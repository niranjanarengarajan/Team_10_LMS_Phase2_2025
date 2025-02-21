package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.TestContext;

public class ProgramAddPage {
	public WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private TestContext testcontext;

	 public ProgramAddPage(WebDriver driver,TestContext testcontext){
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.actions= new Actions(driver);
	        this.testcontext=testcontext;
	        PageFactory.initElements(driver, this);
	    }
}
