package com.calley.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    
    @BeforeSuite
    public void beforeSuite() {
        // Initialize any suite level setup
    }
    
    @BeforeMethod
    public void setUp() {
        WebDriverFactory.initDriver();
    }
    
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
} 