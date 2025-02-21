package com.hooks;


import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.utilities.ConfigReader;
import com.utilities.LoggerLoad;
import com.utilities.TestContext;

public class HooksClass {
    private WebDriver driver;
    
    
    
    private TestContext testcontext;
	private ConfigReader configreader; 
	
// inject TestContext constructor
 public HooksClass(TestContext testcontext) {
     this.testcontext = testcontext;
     this.configreader = new ConfigReader();
 }
 
 @Before
 public void setUp() {
     LoggerLoad.logInfo("Initializing WebDriver");
     String browserName = configreader.browserType(); 
     WebDriver driver = testcontext.getDriverFactory().initialiseBrowser(browserName); 
     testcontext.setDriver(driver); 
     LoggerLoad.logInfo("Navigating to: " + configreader.getLmsPortalUrl());
     testcontext.getDriver().get(configreader.getLmsPortalUrl());
     
 }

 @After
 public void tearDown() {
     if (driver != null) {
         driver.quit();
     }
 }
 
}
 
 
 
 

//    public HooksClass(TestContext picoSetup) {
//        this.picoSetup = picoSetup;
//        //this.configreader = new ConfigReader();
//    }
//
//    @Before
//    public void setUp() {
//        if (picoSetup.getDriver() == null) {
//            // Get browser type from ConfigReader via PicoContainer
//            String browser = picoSetup.getConfigReader().browserType();
//            
//            // Initialize WebDriver and set it in PicoContainer
//            driver = picoSetup.getDriverFactory().initializeWebDriver(browser);
//            picoSetup.setDriver(driver);
//        } else {
//            // Reuse the already initialized driver
//            driver = picoSetup.getDriver();
//        }
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            picoSetup.setDriver(null); // Clean up driver reference in PicoContainer
//        }
//    }
