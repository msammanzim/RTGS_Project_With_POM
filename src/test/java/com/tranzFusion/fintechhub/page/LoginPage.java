package com.tranzFusion.fintechhub.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators for the login page elements
    private By loginLink = By.xpath("//a[@id='LnkLogin']");
    private By usernameField = By.xpath("//input[@id='txtUserName']");
    private By passwordField = By.xpath("//input[@id='txtUserPassword']");
    private By loginButton = By.xpath("//input[@id='btnLogIn']");
    private By errorModal = By.xpath("//div[contains(@class,'modal-content')]");

    // Constructor to initialize the driver
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Click the 'Start Session' link
    public LoginPage clickToStartSession() {
        waitForElement(loginLink);
        getWebElement(loginLink).click();
        return this;
    }

    // Fill the username field
    public LoginPage fillUpUserName(String username) {
        waitForElement(usernameField);
        getWebElement(usernameField).clear();
        getWebElement(usernameField).sendKeys(username);
        return this;
    }

    // Fill the password field
    public LoginPage fillUpPassword(String password) {
        waitForElement(passwordField);
        getWebElement(passwordField).clear();
        getWebElement(passwordField).sendKeys(password);
        return this;
    }

    // Click the login button and return HomePage if login succeeds
    public HomePage clickLoginBtn() {
        getWebElement(loginButton).click();
        return getInstance(HomePage.class);  // Assuming successful login leads to HomePage
    }

    // Modified method to click login and return the same page on failure
    public LoginPage clickLoginPage() {
        getWebElement(loginButton).click();

        if (hasError()) {
            return this;  // Stay on the LoginPage if there's an error
        } else {
            return getInstance(LoginPage.class);  // Navigate to HomePage if login is successful
        }
    }

    // Check if an error modal is displayed
    public boolean hasError() {
        return getWebElements(errorModal).size() > 0;  // Check for presence of error modal
    }
}