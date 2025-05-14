# Calley Team Account Automation

This project automates testing of Calley Team Account setup, including user registration, login, agent creation, and list distribution through CSV upload using Selenium WebDriver and TestNG in Java.

## Project Structure

```
calley-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── calley/
│   │               ├── pages/ - Page Object classes
│   │               ├── utils/ - Utility classes
│   │               └── config/ - Configuration files
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── calley/
│       │           └── tests/ - Test classes
│       └── resources/
│           └── testdata/ - Test data files
├── pom.xml - Maven configuration
├── testng.xml - TestNG configuration
└── README.md - This file
```

## Prerequisites

- Java JDK 11 or higher
- Maven 3.8 or higher
- Chrome/Firefox browser installed

## Setup

1. Clone the repository:
```
git clone https://github.com/yourusername/calley-automation.git
cd calley-automation
```

2. Update test configuration in `src/main/java/com/calley/config/config.properties` as needed:
   - Update browser type
   - Update test data (user credentials, agent info, etc.)

## Running the Tests

1. Run all tests:
```
mvn clean test
```

2. Run specific test:
```
mvn test -Dtest=RegistrationTest
mvn test -Dtest=LoginTest
mvn test -Dtest=AgentsTest
mvn test -Dtest=ImportListTest
```

## Test Scenarios

1. **User Registration Test**
   - Navigates to registration page
   - Fills in registration form
   - Selects Calley Teams plan
   - Submits form and verifies registration

2. **User Login Test**
   - Navigates to login page
   - Enters credentials
   - Submits form and verifies login

3. **Add Agents Test**
   - Logs in to the system
   - Navigates to agent management
   - Adds a new agent
   - Verifies agent addition

4. **Import List Test**
   - Logs in to the system
   - Navigates to Call List > Power Import
   - Enters list information
   - Uploads CSV file
   - Maps fields
   - Imports the list and verifies import

## Notes

- This project uses Page Object Model (POM) for better code organization and maintainability
- WebDriverManager is used for automatic driver management
- Test data is configured through properties file for easy maintenance 