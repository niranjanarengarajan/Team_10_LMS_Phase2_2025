package com.stepdefinitions;

import com.pages.HomePage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.codoid.products.exception.FilloException;
import com.driverManager.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    
        private WebDriver driver;
        private HomePage homePage;
        private ConfigReader configReader;

        private ExcelReader excelReader;

    
    
    public HomePageSteps()  {
          driver = DriverFactory.getDriver(); // Utilize DriverFactory for driver management
          homePage = new HomePage(driver);
          configReader = new ConfigReader();
          excelReader = new ExcelReader();
    }
    
    
    @Given("Admin is on login Page")
    public void admin_is_on_login_page() {
       
         driver.get(configReader.getUrl()); 
            System.out.println("Admin is on the login page");;
    }

    @When("Admin enters valid data in all field and  clicks login button")
    public void admin_enters_valid_data_in_all_field_and_clicks_login_button() throws FileNotFoundException, IOException, FilloException {
    	Map<String, String> loginData = excelReader.getLoginData("Positive"); // Get login data from Excel

        String username = loginData.get("USER");
        String password = loginData.get("PASSWORD");
        String role = loginData.get("ROLE");
      
        homePage.setLoginDetails(username, password, role);
        homePage.clickloginButton(); // Click the login button
    }

    @Then("Admin should see {string} as title")
    public void admin_should_see_as_title(String expectedTitle) {
    	   String actualTitle = driver.getTitle();
    	    System.out.println("Expected Title: " + expectedTitle);
    	    System.out.println("Actual Title: " + actualTitle);
    	    assert actualTitle.equals(expectedTitle) : "Expected title does not match actual title";
    	    System.out.println("Admin sees the correct title: " + actualTitle);
    }
}