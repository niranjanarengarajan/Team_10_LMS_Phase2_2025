package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramPage {

	
	WebDriver pdriver;
	public ProgramPage(WebDriver driver) {
	pdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"program\"]")
	@CacheLookup
	private WebElement PROGRAM_NV;
	
	
	private String PROGRAM_URLL="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/program";
	
	public void clickNavigationBar(String ModuleName)
	{
		switch(ModuleName) {
		case"Program":
			PROGRAM_NV.click();
			break;
		}
			
	}
	
	public boolean validate_navbar_pagenav(String ModuleName)
	{
		boolean result=false;
		switch(ModuleName) {
		case"Program":
			result=pdriver.getCurrentUrl().equalsIgnoreCase(PROGRAM_URLL);
			break;
		}
		
		
		return result;
	}
}
