package pipeline;

import automation.generator.LLMTestGeneratorSelToWDIO;
import automation.generator.LLMTestGeneratorSelToPlaywright;
import automation.generator.LLMTestGeneratorSelToCypress;
import automation.generator.TestCodeGenerator;

public class TestAutomationPipeline {

    public static void main(String[] args) {


        String selCode = "package tests;\n" +
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


     //   seleniumToWebDriverIO(selCode);
     //   seleniumToPlayWright(selCode);
        seleniumToCypress(selCode);
    }

    public static void seleniumToWebDriverIO(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToWDIO llmGen = new LLMTestGeneratorSelToWDIO();
        String llmRawOutput = llmGen.generateTestCases(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        System.out.println("Generated test code written to " + finalTestCode);
    }

    public static void seleniumToPlayWright(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToPlaywright llmGen = new LLMTestGeneratorSelToPlaywright();
        String llmRawOutput = llmGen.generateTestCases(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        System.out.println("Generated test code written to " + finalTestCode);
    }

    public static void seleniumToCypress(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToCypress llmGen = new LLMTestGeneratorSelToCypress();
        String llmRawOutput = llmGen.generateTestCases(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        System.out.println("Generated test code written to " + finalTestCode);
    }
}
