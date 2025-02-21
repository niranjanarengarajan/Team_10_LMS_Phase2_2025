package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driverManager.DriverFactory;
import com.pages.ProgramAddPage;

public class TestContext {
	private WebDriver driver;
	private ProgramAddPage programadd;
	private DriverFactory driverfactory;
	private ConfigReader configreader;
	private WebDriverWait wait;
	private Actions actions;
	
	// initializing the DriverFactory
		public TestContext() {
			this.driverfactory = new DriverFactory();
			this.configreader = new ConfigReader(); // config reader initilise
		}

		
		public DriverFactory getDriverFactory() {
			return driverfactory;
		}

		// WebDriver instance
		public WebDriver getDriver() {
			return driver;
		}
		public WebDriverWait getWait() {
			return wait;
		}

		
		public void setDriver(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			this.actions = new Actions(driver); // Initialize Actions here, after driver is set
			this.programadd = new ProgramAddPage(driver,this);
			}
		
//		public String getApplicationURL() {
//			return configreader.getLmsPortalUrl(); // Method to get URL
//		}
		
	public ProgramAddPage getProgramAdd() {
		return programadd;
	}
	 
	

//	public ConfigReader getConfigReader() {
//		// TODO Auto-generated method stub
//		return configreader;
//	}
	
	


}
