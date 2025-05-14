package com.calley.pages;

import com.calley.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PowerImportPage extends BasePage {

    @FindBy(id = "txtListName")
    private WebElement listNameField;

    @FindBy(id = "ddlAgents")
    private WebElement agentsDropdown;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadInput;

    @FindBy(xpath = "//button[contains(text(), 'Upload')]")
    private WebElement uploadButton;

    @FindBy(xpath = "//table[@id='mappingTable']//select")
    private List<WebElement> mappingSelects;

    @FindBy(id = "btnImport")
    private WebElement importButton;

    @FindBy(xpath = "//div[contains(@class, 'success-message')]")
    private WebElement successMessage;

    public PowerImportPage() {
        super();
    }

    public void enterListName(String name) {
        sendKeys(listNameField, name);
    }

    public void selectAgent(String agentName) {
        Select agentSelect = new Select(agentsDropdown);
        agentSelect.selectByVisibleText(agentName);
    }

    public void uploadCsvFile(String filePath) {
        fileUploadInput.sendKeys(filePath);
        click(uploadButton);
    }

    public void mapFields() {
        // Map CSV fields to system fields 
        // This is a simplified version. In reality, we would need to map specific fields
        for (int i = 0; i < mappingSelects.size(); i++) {
            Select mappingSelect = new Select(mappingSelects.get(i));
            // Map columns based on index, assuming a standard order
            // First column is typically name, second is phone, etc.
            switch (i) {
                case 0:
                    mappingSelect.selectByVisibleText("Name");
                    break;
                case 1:
                    mappingSelect.selectByVisibleText("Phone Number");
                    break;
                case 2:
                    mappingSelect.selectByVisibleText("Email");
                    break;
                case 3:
                    mappingSelect.selectByVisibleText("Notes");
                    break;
                default:
                    // Skip or select a default mapping
                    break;
            }
        }
    }

    public void clickImport() {
        click(importButton);
    }

    public boolean isImportSuccessful() {
        return isElementDisplayed(successMessage) &&
               getText(successMessage).contains("successfully");
    }

    public void importContactList(String listName, String agentName, String csvFilePath) {
        enterListName(listName);
        selectAgent(agentName);
        uploadCsvFile(csvFilePath);
        mapFields();
        clickImport();
    }
} 