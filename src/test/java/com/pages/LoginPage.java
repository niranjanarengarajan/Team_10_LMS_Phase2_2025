package com.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.EnvironmentConstants;
import com.driverManager.DriverFactory;

public class LoginPage {
	
	WebDriver ldriver;
	EnvironmentConstants constants = new EnvironmentConstants();
	public LoginPage(WebDriver driver) {
	ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"username\"]")
	@CacheLookup
	private static WebElement USER_FIELD;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	@CacheLookup
	private static WebElement PASSWORD_FIELD;
	
	@FindBy(xpath="//div[@class='mat-select-arrow-wrapper ng-tns-c161-3']")
	@CacheLookup
	private static WebElement DROPDOWN;
	
	@FindBy(xpath="//span[normalize-space()='Admin']")
	@CacheLookup
	private static WebElement ADMIN_ROLE_FIELD;
	
	@FindBy(xpath="//button[@id='login']")
	@CacheLookup
	private static WebElement LOGIN_BTN;
	
	@FindBy(xpath="//*[@id=\"logout\"]")
	@CacheLookup
	private static WebElement  LOGOUT_BTN;
	
	@FindBy(xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
   private WebElement roleDropdown;
	
	// Instead of XPath, try using a CSS Selector (if applicable)
	//@FindBy(css = "button[class='mat-select-trigger']")
	//private WebElement roleDropdown;

	
	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
    private WebElement loginButton;
	
	
	
	public String HOMEPAGE_URL="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";
	
	public void enterLoginDetails()
	{
		
		 System.out.println("I am inside Page");
		 try {
		 
		USER_FIELD.sendKeys(constants.getUsername());
		PASSWORD_FIELD.sendKeys(constants.getPassword());
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectRole(constants.getRole());
		((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", LOGIN_BTN);
		LOGIN_BTN.click();
        // Take screenshot for debugging
         //  File srcFile = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
           
			//FileUtils.copyFile(srcFile, new File("path_to_screenshot.png"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	private void selectRole(String role) {
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));

	    try {
	        // Wait until the dropdown is clickable
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN));
	        dropdown.click();

	        // Wait until the role option is visible
	        WebElement roleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + role + "')]")));

	        // Scroll into view and click the role
	        ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", roleOption);
	        wait.until(ExpectedConditions.elementToBeClickable(roleOption)).click();

	       
	        System.out.println("Role selected: " + role);
	    } catch (Exception e) {
	        System.out.println("Failed to select role: " + role);
	        e.printStackTrace();
	    }
	}

	
	public boolean validateLoginfunction()
	{
		boolean result=false;
		
	

		System.out.println( "I am inside Validate");
		System.out.println("Currenturl is :"+DriverFactory.getDriver().getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
		
		System.out.println("After wait Currenturl is :"+DriverFactory.getDriver().getCurrentUrl());
		result=DriverFactory.getDriver().getCurrentUrl().equalsIgnoreCase(HOMEPAGE_URL);
		
		return result;
	}
	
	
	public void click_logout()
	{
		LOGOUT_BTN.click();
	}

}
