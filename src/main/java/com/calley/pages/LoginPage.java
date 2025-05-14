package com.calley.pages;

import com.calley.utils.BasePage;
import com.calley.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "txtEmail")
    private WebElement emailField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'dashboard')]")
    private WebElement dashboardElement;

    public LoginPage() {
        super();
    }

    public void navigateToLoginPage() {
        driver.get(ConfigReader.getProperty("url.login"));
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public boolean isDashboardDisplayed() {
        return isElementDisplayed(dashboardElement);
    }

    public AgentsPage loginUser(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return new AgentsPage();
    }
} 