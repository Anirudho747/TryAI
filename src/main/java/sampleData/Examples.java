package sampleData;

public class Examples {


       public static String seleniumToPlayWrightExample = "\tExample:\n" +
               "\n" +
               "Selenium Java (Input)\n" +
               "\n" +
               "```java\n" +
               "import org.openqa.selenium.WebDriver;\n" +
               "import org.openqa.selenium.chrome.ChromeDriver;\n" +
               "\n" +
               "public class PrintTitle {\n" +
               "  public static void main(String[] args) {\n" +
               "    WebDriver driver = new ChromeDriver();\n" +
               "    driver.get(\"http://playwright.dev\");\n" +
               "    System.out.println(driver.getTitle());\n" +
               "    driver.quit();\n" +
               "  }\n" +
               "}\n" +
               "```\n" +
               "\n" +
               "Playwright TypeScript (Expected Output)\n" +
               "\n" +
               "```typescript\n" +
               "import { test, expect } from '@playwright/test';" +
               "\n" +
               "test('has title', async ({ page }) => {\n" +
               "  await page.goto('https://playwright.dev/');\n" +
               "\n" +
               "  // Expect a title \"to contain\" a substring.\n" +
               "  await expect(page).toHaveTitle(/Playwright/);\n" +
               "});\n" +
               "```";

       public static String seleniumToWDIOExample = "\tExample:\n" +
               "\n" +
               "Selenium Java (Input)\n" +
               "\n" +
               "```java\n" +
               "import org.openqa.selenium.WebDriver;\n" +
               "import org.openqa.selenium.chrome.ChromeDriver;\n" +
               "\n" +
               "public class PrintTitle {\n" +
               "  public static void main(String[] args) {\n" +
               "    WebDriver driver = new ChromeDriver();\n" +
               "    driver.get(\"http://playwright.dev\");\n" +
               "    System.out.println(driver.getTitle());\n" +
               "    driver.quit();\n" +
               "  }\n" +
               "}\n" +
               "```\n" +
               "\n" +
               "WDIO TypeScript (Expected Output)\n" +
               "\n" +
               "```typescript\n" +
               "const { expect } = require('@wdio/expect');\n" +
               "const { remote } = require('webdriverio');\n" +
               "\n" +
               "describe('WDIO Page', () => {\n" +
               "  it('has title', async () => {\n" +
               "    // Create a new browser instance\n" +
               "    const browser = await remote({\n" +
               "      capabilities: {\n" +
               "        browserName: 'chrome',\n" +
               "      },\n" +
               "    });\n" +
               "\n" +
               "    // Navigate to the desired URL\n" +
               "    await browser.url('https://wdio.dev/');\n" +
               "\n" +
               "    // Expect a title \"to contain\" a substring\n" +
               "    await expect(await browser.getTitle()).toContain('WDIO');\n" +
               "\n" +
               "    // Close the browser instance\n" +
               "    await browser.deleteSession();\n" +
               "  });\n" +
               "});\n" +
               "```";

       public static String seleniumToCypressExample = "\tExample:\n" +
               "\n" +
               "Selenium Java (Input)\n" +
               "\n" +
               "```java\n" +
               "import org.openqa.selenium.WebDriver;\n" +
               "import org.openqa.selenium.chrome.ChromeDriver;\n" +
               "\n" +
               "public class PrintTitle {\n" +
               "  public static void main(String[] args) {\n" +
               "    WebDriver driver = new ChromeDriver();\n" +
               "    driver.get(\"http://playwright.dev\");\n" +
               "    System.out.println(driver.getTitle());\n" +
               "    driver.quit();\n" +
               "  }\n" +
               "}\n" +
               "```\n" +
               "\n" +
               "Cypress TypeScript (Expected Output)\n" +
               "\n" +
               "```typescript\n" +
               "describe('Has title', () => {\n" +
               "  it('visits the Cypress homepage', () => {\n" +
               "    cy.visit('https://cypress.dev/');\n" +
               "\n" +
               "    // Expect a title \"to contain\" a substring.\n" +
               "    cy.title().should('contain', 'Cypress');\n" +
               "  });\n" +
               "});;\n" +
               "});\n" +
               "```";

       public static String jiraToTestCaseExample =
               "Example\n" +
                       "Jira Story\n" +
                       "Title: As a user, I want to log in to the ecommerce web application with a valid username and password, so that I can access my account and shop securely.\n" +
                       "Description:\n" +
                       "* The user should be able to enter their username and password in the respective fields on the login page.\n" +
                       "* The username field should accept alphanumeric characters and special characters.\n" +
                       "* The password field should be masked for security purposes.\n" +
                       "* A \"Forgot Password\" checkbox should be provided, which when checked, should redirect the user to a password recovery page.\n" +
                       "* A \"Submit\" button should be provided, which when clicked, should authenticate the user's credentials and log them in to the application.\n" +
                       "* To improve performance, the login functionality should utilize a caching mechanism, such as Redis or Memcached, to store user session data for a limited period (e.g. 30 minutes).\n" +
                       "* When the user logs in successfully, they should be redirected to their account dashboard or the home page of the application.\n" +
                       "Acceptance Criteria:\n" +
                       "1. The username and password fields are displayed on the login page.\n" +
                       "2. The username field accepts alphanumeric characters and special characters.\n" +
                       "3. The password field is masked for security purposes.\n" +
                       "4. The \"Forgot Password\" checkbox is displayed and functional.\n" +
                       "5. The \"Submit\" button is displayed and functional.\n" +
                       "6. When the user enters valid credentials and clicks the \"Submit\" button, they are logged in to the application and redirected to their account dashboard or home page.\n" +
                       "7. The login functionality utilizes a caching mechanism to store user session data for a limited period.\n" +
                       "8. The caching mechanism is configured to expire after 30 minutes of inactivity.\n" +
                       "9. The user is logged out automatically after the caching mechanism expires.\n" +
                       "10. The application handles invalid login attempts and displays an error message to the user.\n" +
                       "Definition of Done:\n" +
                       "* The login functionality is implemented and tested with valid and invalid credentials.\n" +
                       "* The caching mechanism is integrated and configured to store user session data for a limited period.\n" +
                       "* The application handles edge cases, such as multiple failed login attempts, and displays an error message to the user.\n" +
                       "* The code is reviewed and approved by the development team and meets the coding standards.\n" +
                       "* The functionality is tested on different browsers and devices to ensure compatibility.\n" +
                       "Story Points: 8\n" +
                       "Priority: High\n" +
                       "Labels: Ecommerce, Login, Authentication, Caching, Security\n" +
                       "\n" +
                       "Test cases for the above Story\n" +
                       "\n" +
                       "```testcases\n" +
                       "**Test Cases for Ecommerce Web Application**\n" +
                       "\n" +
                       "| **Test Case ID** | **Test Case Description** | **Preconditions** | **Steps** | **Expected Result** |\n" +
                       "| --- | --- | --- | --- | --- |\n" +
                       "| 1 | Valid Login | Valid username and password | 1. Launch the ecommerce web application, 2. Enter a valid username in the username field, 3. Enter a valid password in the password field, 4. Click the \"Submit\" button to login to the application | User is logged in to the application and redirected to their account dashboard or home page |\n" +
                       "| 2 | Invalid Login | Invalid username or password | 1. Launch the ecommerce web application, 2. Enter an invalid username in the username field, 3. Enter a valid password in the password field, 4. Click the \"Submit\" button to attempt to login to the application | An error message is displayed indicating that the username or password is invalid |\n" +
                       "| 3 | Forgot Password | Forgotten password | 1. Launch the ecommerce web application, 2. Check the \"Forgot Password\" checkbox, 3. Click the \"Submit\" button to request a password reset, 4. Verify that the user is redirected to the password recovery page | The user is redirected to the password recovery page where they can reset their password |\n" +
                       "| 4 | Username Field Validation | Invalid characters in username field | 1. Launch the ecommerce web application, 2. Enter a username with invalid characters (e.g. only special characters) in the username field, 3. Verify that the username field accepts alphanumeric characters and special characters, 4. Check that the application does not throw an error for valid username characters | The username field accepts alphanumeric characters and special characters, and does not throw an error for valid username characters |\n" +
                       "| 5 | Password Field Masking | Password entry | 1. Launch the ecommerce web application, 2. Enter a password in the password field, 3. Verify that the password field is masked for security purposes (e.g. bullets or asterisks are displayed instead of the actual password), 4. Check that the password field masking is consistent throughout the application | The password field is masked for security purposes, and the masking is consistent throughout the application |\n" +
                       "| 6 | Caching Mechanism | 30 minutes of inactivity after login | 1. Launch the ecommerce web application, 2. Log in to the application with a valid username and password, 3. Wait for 30 minutes of inactivity, 4. Verify that the user is automatically logged out of the application after 30 minutes of inactivity | The user is automatically logged out of the application after 30 minutes of inactivity |\n" +
                       "| 7 | Multiple Failed Login Attempts | Multiple attempts with invalid credentials | 1. Launch the ecommerce web application, 2. Enter invalid credentials (username and/or password) multiple times, 3. Verify that an error message is displayed indicating that the username or password is invalid, 4. Check that the application does not allow the user to login with invalid credentials | An error message is displayed indicating that the username or password is invalid, and the application does not allow the user to login with invalid credentials |\n" +
                       "| 8 | Browser and Device Compatibility | Different browsers and devices | 1. Launch the ecommerce web application on different browsers (e.g. Chrome, Firefox, Safari), 2. Launch the ecommerce web application on different devices (e.g. desktop, laptop, mobile), 3. Log in to the application with a valid username and password on each browser and device, 4. Verify that the application is compatible with different browsers and devices | The application is compatible with different browsers and devices, and the user can login and use the application without any issues |\n" +
                       "| 9 | Edge Cases | Empty username or password | 1. Launch the ecommerce web application, 2. Enter an empty username or password, 3. Verify that an error message is displayed indicating that the username or password is invalid, 4. Check that the application does not allow the user to login with empty or invalid credentials | An error message is displayed indicating that the username or password is invalid, and the application does not allow the user to login with empty or invalid credentials" +
                       "\n" +
                       "\n";

       public static String voiceToTextExample =
               "Example\n" +
                       "Instruction :Please provide a simple Voice to text conversion for the attached voice recording\n"+
                       "Context : I am preparing a platform to automatically convert Voice Commands to Text Instructions\n" +
                       "Example :\n" +
                       "When I play the file saved in\n" +
                       "src/main/java/sampleData/ExampleVoice.m4a" +
                       "I get below text ”\n" +
                       " This is just a sample audio file to check if the conversion is happening properly.\n" +
                       "\n" +
                       "Output should be in word format";

}
