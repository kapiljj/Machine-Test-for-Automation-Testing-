package com.calley.tests;

import com.calley.pages.AgentsPage;
import com.calley.pages.LoginPage;
import com.calley.pages.PowerImportPage;
import com.calley.utils.BaseTest;
import com.calley.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImportListTest extends BaseTest {

    @Test(description = "Test importing contacts list from CSV")
    public void testImportContactsList() {
        // First login with valid credentials
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        
        String email = ConfigReader.getProperty("user.email");
        String password = ConfigReader.getProperty("user.password");
        
        AgentsPage agentsPage = loginPage.loginUser(email, password);
        
        // Navigate to Power Import page
        PowerImportPage powerImportPage = agentsPage.navigateToPowerImport();
        
        // Get import data
        String listName = ConfigReader.getProperty("list.name");
        String agentName = ConfigReader.getProperty("agent.name");
        String csvFilePath = ConfigReader.getProperty("csv.file.path");
        
        // Import the contact list
        powerImportPage.importContactList(listName, agentName, csvFilePath);
        
        // Verify import was successful
        Assert.assertTrue(powerImportPage.isImportSuccessful(), 
                         "Contact list import failed");
    }
} 