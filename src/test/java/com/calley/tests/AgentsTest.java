package com.calley.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.calley.pages.AgentsPage;
import com.calley.pages.LoginPage;
import com.calley.utils.BaseTest;
import com.calley.utils.ConfigReader;

public class AgentsTest extends BaseTest {

    @Test(description = "Test adding a new agent")
    public void testAddAgent() {
        // First login with valid credentials
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        
        String email = ConfigReader.getProperty("user.email");
        String password = ConfigReader.getProperty("user.password");
        
        AgentsPage agentsPage = loginPage.loginUser(email, password);
        
        // Add a new agent
        String agentName = ConfigReader.getProperty("agent.name");
        String agentEmail = ConfigReader.getProperty("agent.email");
        
        agentsPage.addAgent(agentName, agentEmail);
        
        // Verify agent was added successfully
        Assert.assertTrue(agentsPage.isAgentAddedSuccessfully(), 
                         "Agent was not added successfully");
    }
} 