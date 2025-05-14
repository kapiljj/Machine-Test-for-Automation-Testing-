package com.calley.tests;

import com.calley.pages.LoginPage;
import com.calley.utils.BaseTest;
import com.calley.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Test user login functionality")
    public void testUserLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        
        // Get test data from properties file
        String email = ConfigReader.getProperty("user.email");
        String password = ConfigReader.getProperty("user.password");
        
        // Login with user credentials
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        
        // Verify login was successful
        Assert.assertTrue(loginPage.isDashboardDisplayed(), 
                         "User login failed");
    }
} 