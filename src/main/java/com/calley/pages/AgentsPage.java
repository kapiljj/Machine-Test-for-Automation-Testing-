package com.calley.pages;

import com.calley.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgentsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Add Agent')]")
    private WebElement addAgentButton;

    @FindBy(id = "txtAgentName")
    private WebElement agentNameField;

    @FindBy(id = "txtAgentEmail")
    private WebElement agentEmailField;

    @FindBy(id = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'success-message')]")
    private WebElement successMessage;

    @FindBy(xpath = "//a[contains(text(), 'Call List')]")
    private WebElement callListMenu;

    @FindBy(xpath = "//a[contains(text(), 'Power Import')]")
    private WebElement powerImportOption;

    public AgentsPage() {
        super();
    }

    public void clickAddAgent() {
        click(addAgentButton);
    }

    public void enterAgentName(String name) {
        sendKeys(agentNameField, name);
    }

    public void enterAgentEmail(String email) {
        sendKeys(agentEmailField, email);
    }

    public void clickSave() {
        click(saveButton);
    }

    public boolean isAgentAddedSuccessfully() {
        return isElementDisplayed(successMessage) &&
               getText(successMessage).contains("successfully");
    }

    public PowerImportPage navigateToPowerImport() {
        click(callListMenu);
        click(powerImportOption);
        return new PowerImportPage();
    }

    public void addAgent(String name, String email) {
        clickAddAgent();
        enterAgentName(name);
        enterAgentEmail(email);
        clickSave();
    }
} 