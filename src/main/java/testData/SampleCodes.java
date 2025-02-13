package testData;

public class SampleCodes {

       public static String userCode = "package tests;\n" +
            "\n" +
            "import java.time.Duration;\n" +
            "\n" +
            "import org.openqa.selenium.By;\n" +
            "import org.openqa.selenium.WebElement;\n" +
            "import org.openqa.selenium.chrome.ChromeDriver;\n" +
            "import org.openqa.selenium.support.ui.Select;\n" +
            "\n" +
            "public class CreateLead {\n" +
            "\n" +
            "public static void main(String[] args) {\n" +
            "\n" +
            "// Step 1) Launch the chrome browser\n" +
            "ChromeDriver driver = new ChromeDriver();\n" +
            "\n" +
            "// Step 2) Load the URL\n" +
            "driver.get(\"http://leaftaps.com/opentaps\");\n" +
            "\n" +
            "// Step 3) Maximize the chrome browser\n" +
            "driver.manage().window().maximize();\n" +
            "driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));\n" +
            "\n" +
            "// Step 4) Find the username and type the value\n" +
            "driver.findElement(By.id(\"username\")).sendKeys(\"DemoSalesManager\");\n" +
            "\n" +
            "// Step 5) Find the password and type the value\n" +
            "driver.findElement(By.id(\"password\")).sendKeys(\"crmsfa\");\n" +
            "\n" +
            "// Step 6) Find the login button and click\n" +
            "driver.findElement(By.className(\"decorativeSubmit\")).click();\n" +
            "\n" +
            "// Step 7) Print the title\n" +
            "System.out.println(driver.getTitle());\n" +
            "\n" +
            "// Step 8) Click CRM/SFA link\n" +
            "driver.findElement(By.linkText(\"CRM/SFA\")).click();\n" +
            "\n" +
            "// Step 9) Click Create Lead Link\n" +
            "driver.findElement(By.linkText(\"Create Lead\")).click();\n" +
            "\n" +
            "// Step 10) Find the company name and type the value\n" +
            "driver.findElement(By.id(\"createLeadForm_companyName\")).sendKeys(\"TestLeaf\");\n" +
            "\n" +
            "// Step 11) Find the first name and type your first name\n" +
            "driver.findElement(By.id(\"createLeadForm_firstName\")).sendKeys(\"Babu\");\n" +
            "\n" +
            "// Step 12) Find the last name and type your last name\n" +
            "driver.findElement(By.id(\"createLeadForm_lastName\")).sendKeys(\"Manickam\");\n" +
            "\n" +
            "// Step 13) Select the Source dropdown with one of the visible text\n" +
            "WebElement source = driver.findElement(By.id(\"createLeadForm_dataSourceId\"));\n" +
            "Select dataSource = new Select(source);\n" +
            "dataSource.selectByVisibleText(\"Employee\");\n" +
            "\n" +
            "// Step 14) Select the marketing campaign with one of the value\n" +
            "WebElement marketing = driver.findElement(By.id(\"createLeadForm_marketingCampaignId\"));\n" +
            "Select campaign = new Select(marketing);\n" +
            "campaign.selectByValue(\"9001\");\n" +
            "\n" +
            "// Step 15) Click Create Lead Button\n" +
            "driver.findElement(By.name(\"submitButton\")).click();\n" +
            "\n" +
            "// Step 16) Print the new title\n" +
            "System.out.println(driver.getTitle());\n" +
            "\n" +
            "// Step 17) Close the browser\n" +
            "driver.close();\n" +
            "\n" +
            "}\n" +
            "\n" +
            "} ";

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
}
