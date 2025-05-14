# How to Run the Calley Team Account Automation Tests

This document provides steps to successfully run the Selenium automation tests for Calley Team Account setup.

## Prerequisites

1. **Java JDK 11** - The project is configured to work with Java 11
   - Download from [Adoptium](https://adoptium.net/temurin/releases/?version=11)
   - Install and set JAVA_HOME environment variable

2. **Maven 3.8+** - For dependency management and running tests
   - Download from [Maven](https://maven.apache.org/download.cgi)
   - Install and add to your system PATH

3. **Chrome/Firefox Browser** - Tests are configured to run on Chrome by default
   - Make sure you have the latest version installed

## Configuration

1. Update test configuration in `src/main/java/com/calley/config/config.properties` if needed:
   - Change browser type (`chrome`, `firefox`, `edge`)
   - Update test data (user credentials, agent info, etc.)
   - Adjust wait times if needed

## Running the Tests

### Using Maven

1. Open a command prompt/terminal
2. Navigate to the project root directory
3. Run all tests:
```
mvn clean test
```

4. To run a specific test class:
```
mvn test -Dtest=RegistrationTest
mvn test -Dtest=LoginTest
mvn test -Dtest=AgentsTest
mvn test -Dtest=ImportListTest
```

### Fixing Common Issues

#### TestNG Dependency Issue
- If you get errors related to TestNG, ensure the BaseTest class is in the test directory (not main)
- The class should be in: `src/test/java/com/calley/utils/BaseTest.java`

#### Java Module Access Issues
- If using Java 17+, you may need to add module access flags:
```
mvn test -Dtest=RegistrationTest --add-opens=java.base/java.lang=ALL-UNNAMED
```

#### WebDriver Issues
- The project uses WebDriverManager to automatically download the appropriate driver
- If you encounter WebDriver-related errors:
  1. Download the Chrome/Firefox driver manually
  2. Update the WebDriverFactory class to use the specific driver path

## Project Structure

- **Pages Package** (`src/main/java/com/calley/pages`): Contains Page Object classes
- **Utils Package** (`src/main/java/com/calley/utils`): Contains utility classes
- **Config Package** (`src/main/java/com/calley/config`): Contains configuration files
- **Tests Package** (`src/test/java/com/calley/tests`): Contains test classes
- **Test Resources** (`src/test/resources/testdata`): Contains test data like CSV files

## Troubleshooting

If you encounter any issues running the tests:

1. Check Java version with `java -version` (should be Java 11)
2. Verify Maven installation with `mvn -version`
3. Ensure all dependencies are downloaded correctly
4. Check browser and WebDriver compatibility
5. If on Windows, run the command prompt as Administrator if needed

## Test Execution Reports

After running the tests, the TestNG reports can be found in:
- `target/surefire-reports/index.html` 