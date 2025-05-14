package com.calley.tests;

import com.calley.pages.RegistrationPage;
import com.calley.utils.BaseTest;
import com.calley.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(description = "Test user registration functionality")
    public void testUserRegistration() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistrationPage();
        
        // Get test data from properties file
        String name = ConfigReader.getProperty("user.name");
        String email = ConfigReader.getProperty("user.email");
        String phone = ConfigReader.getProperty("user.phone");
        String password = ConfigReader.getProperty("user.password");
        
        // Register a new user
        registrationPage.enterFullName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPhoneNumber(phone);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(password);
        registrationPage.selectPlan("Calley Teams");
        registrationPage.clickSignUp();
        
        // Verify registration was successful
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(), 
                         "User registration failed");
    }
} 