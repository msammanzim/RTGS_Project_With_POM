package com.tranzFusion.fintechhub.testcase;


import com.tranzFusion.fintechhub.page.HomePage;
import com.tranzFusion.fintechhub.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test(priority = 0)
    public void doLoginWithoutPassword() {
        loginPage = page.getInstance(LoginPage.class)
                .fillUpUserName("zimadro")         // Enter username
                .clickLoginPage();                 // Try to log in without password

        // Assert that an error is displayed for missing password
        Assert.assertTrue(loginPage.hasError(), "Error message was not displayed for missing password.");
    }

    @Test(priority = 1)
    public void doLoginWithoutUsername() {
        loginPage = page.getInstance(LoginPage.class)
                .fillUpPassword("1")               // Enter password only
                .clickLoginPage();                 // Try to log in without username

        // Assert that an error is displayed for missing username
        Assert.assertTrue(loginPage.hasError(), "Error message was not displayed for missing username.");
    }

    @Test(priority = 2)
    public void doLoginSuccessfully() {
        homePage = page.getInstance(LoginPage.class)
                .fillUpUserName("zimadro")         // Enter valid username
                .fillUpPassword("1")               // Enter valid password
                .clickLoginBtn();                  // Click the login button

        // Assert that the home page is displayed after successful login
        Assert.assertTrue(homePage.hasBankName(), "Login was not successful.");
    }
}
