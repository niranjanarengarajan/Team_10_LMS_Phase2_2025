package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.constants.EnvironmentConstants;

public class LoginPage {
	
	WebDriver ldriver;
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
	
	@FindBy(xpath="//*[@id=\"mat-select-0\"]")
	@CacheLookup
	private static WebElement DROPDOWN;
	
	@FindBy(xpath="//*[@id=\"mat-option-0\"]/span")
	@CacheLookup
	private static WebElement ADMIN_ROLE_FIELD;
	
	@FindBy(xpath="//*[@id=\"login\"]/span[1]")
	@CacheLookup
	private static WebElement LOGIN_BTN;
	
	
	public String HOMEPAGE_URL="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";
	
	public void enterLoginDetails()
	{
		USER_FIELD.sendKeys(EnvironmentConstants.USERNAME);
		PASSWORD_FIELD.sendKeys(EnvironmentConstants.PASSWORD);
		DROPDOWN.click();
		ADMIN_ROLE_FIELD.click();
		LOGIN_BTN.click();
	}
	
	public boolean validateLoginfunction()
	{
		boolean result=false;
		
		
		result=ldriver.getCurrentUrl().equalsIgnoreCase(HOMEPAGE_URL);
		return result;
	}
	
	
	

}
