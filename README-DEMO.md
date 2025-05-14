# Calley Team Account Automation - Demo

This is a demonstration of the Selenium automation framework for the Calley Team Account setup project. The framework is designed to automate the following processes:

1. User Registration
2. User Login
3. Adding Agents
4. Importing Contact Lists (CSV)

## Demo Instructions

1. Run `run_single_test.bat` to see a demonstration of the framework.

## Project Overview

This automation project includes:

- **Page Object Model (POM)** design pattern
- **TestNG** for test execution and assertions
- **WebDriverManager** for browser driver management
- **Data-driven approach** using properties files and CSV
- **Cross-browser compatibility** with Chrome, Firefox, and Edge

## Framework Structure

- **Pages Package**: RegistrationPage, LoginPage, AgentsPage, PowerImportPage
- **Utils Package**: BasePage, WebDriverFactory, ConfigReader, BaseTest
- **Tests Package**: RegistrationTest, LoginTest, AgentsTest, ImportListTest
- **Config Package**: Configuration properties for browsers, URLs, test data
- **Test Data**: Sample CSV file for contact import testing

## Complete Environment Setup

For running the tests in a complete environment, please refer to the `HOW_TO_RUN.md` file, which provides detailed instructions on:

1. Installing prerequisites (Java 11, Maven)
2. Configuring the test environment
3. Running the tests with Maven
4. Troubleshooting common issues 