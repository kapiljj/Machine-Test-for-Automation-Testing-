package com.calley.pages;

import com.calley.utils.BasePage;
import com.calley.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    @FindBy(id = "txtFullName")
    private WebElement nameField;

    @FindBy(id = "txtRegisterEmail")
    private WebElement emailField;

    @FindBy(id = "txtPhoneNumber")
    private WebElement phoneField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "txtConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "ddlTeam")
    private WebElement planDropdown;

    @FindBy(id = "btnSignUp")
    private WebElement signUpButton;

    @FindBy(id = "lblMessage")
    private WebElement messageLabel;

    public RegistrationPage() {
        super();
    }

    public void navigateToRegistrationPage() {
        driver.get(ConfigReader.getProperty("url.registration"));
    }

    public void enterFullName(String name) {
        sendKeys(nameField, name);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPhoneNumber(String phone) {
        sendKeys(phoneField, phone);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterConfirmPassword(String password) {
        sendKeys(confirmPasswordField, password);
    }

    public void selectPlan(String planName) {
        Select planSelect = new Select(planDropdown);
        planSelect.selectByVisibleText(planName);
    }

    public void clickSignUp() {
        click(signUpButton);
    }

    public String getRegistrationMessage() {
        return getText(messageLabel);
    }

    public boolean isRegistrationSuccessful() {
        return isElementDisplayed(messageLabel) && 
               getRegistrationMessage().contains("success");
    }

    public LoginPage registerUser(String name, String email, String phone, String password) {
        enterFullName(name);
        enterEmail(email);
        enterPhoneNumber(phone);
        enterPassword(password);
        enterConfirmPassword(password);
        selectPlan("Calley Teams");
        clickSignUp();
        return new LoginPage();
    }
} 