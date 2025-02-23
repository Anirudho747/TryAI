package pipeline;

import generator.LLMCodeGeneratorSelToWDIO;
import generator.LLMCodeGeneratorSelToPlaywright;
import generator.LLMCodeGeneratorSelToCypress;
import generator.LLMVoiceToTextGenerator;
import generator.LLMTestCaseGenerator;
import generator.LLMTestCaseGeneratorFromSwagger;
import extractor.DataExtractor;
import utils.FileUtils;
import utils.SwaggerParser;
import testData.testJavaCode;
import testData.testJiraStory;

import java.util.Scanner;

public class TestAutomationPipeline {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select your relevant option");
        System.out.println("1 : Selenium Java to WDIO TS");
        System.out.println("2 : Selenium Java to Playwright TS");
        System.out.println("3 : Selenium Java to Cypress TS");
        System.out.println("4 : Jira Story to Test Cases");
        System.out.println("5 : Swagger to Test Cases");
        System.out.println("6 : Voice to Audio Conversion");
        int option  = sc.nextInt();
        switch (option) {
            case 1:
                seleniumToWebDriverIO(testJavaCode.userCode);
                break;
            case 2:
                seleniumToPlayWright(testJavaCode.userCode);
                break;
            case 3:
                seleniumToCypress(testJavaCode.userCode);
                break;
            case 4:
                jiraToTestCase(testJiraStory.jiraStory);
                break;
            case 5:
                swaggerToTestCase();
                break;
            case 6:
                voiceToText();
                break;
            default:
                System.out.println("Please choose relevant options only");
        }

    }

    public static void seleniumToWebDriverIO(String originalCode)
    {
        // Generate test case outline using LLM
        LLMCodeGeneratorSelToWDIO llmGen = new LLMCodeGeneratorSelToWDIO();
        String llmRawOutput = llmGen.generateTestCases(originalCode);

        // Extract only the code from the LLM response
        DataExtractor codeGen = new DataExtractor();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        //Write generated code to a WDIO file
        FileUtils.writeToFile(finalTestCode, "src/autoGeneratedCodes/WDIOScript.ts");

        System.out.println("Generated WDIO Typescript written to " + " src/autoGeneratedCodes/WDIOScript.ts");

    }

    public static void seleniumToPlayWright(String originalCode)
    {
        // Generate test case outline using LLM
        LLMCodeGeneratorSelToPlaywright llmGen = new LLMCodeGeneratorSelToPlaywright();
        String llmRawOutput = llmGen.generateTScode(originalCode);

        // Extract only the code from the LLM response
        DataExtractor codeGen = new DataExtractor();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        //Write generated code to a PlayWright file
        FileUtils.writeToFile(finalTestCode, "src/autoGeneratedCodes/PlaywrightScript.ts");

        System.out.println("Generated Playwright Typescript script written to " + " src/autoGeneratedCodes/PlaywrightScript.ts");
    }

    public static void seleniumToCypress(String originalCode)
    {
        // Generate test case outline using LLM
        LLMCodeGeneratorSelToCypress llmGen = new LLMCodeGeneratorSelToCypress();
        String llmRawOutput = llmGen.generateTScode(originalCode);

        // Extract only the Java code from the LLM response
        DataExtractor codeGen = new DataExtractor();
        String finalTestCode = codeGen.extractTSCode(llmRawOutput);

        //Write generated code to a Cypress file
        FileUtils.writeToFile(finalTestCode, "src/autoGeneratedCodes/CypressScript.ts");

        System.out.println("Generated Cypress Typescript script written to " + " src/autoGeneratedCodes/CypressScript.ts");
    }

    public static void jiraToTestCase(String jiraStory)
    {
        LLMTestCaseGenerator llmGen = new LLMTestCaseGenerator();
        String llmRawOutput = llmGen.generateTestcases(jiraStory);

        DataExtractor codeGen = new DataExtractor();

        String finalTestCode = codeGen.extractTestCase(llmRawOutput);

        //Write generated code to a Cypress file
        FileUtils.writeToFile(finalTestCode, "src/autoGeneratedTestCases/Testcase.gsheet");

        System.out.println("Generated Test cases written to " + " src/autoGeneratedTestCases/Testcase.gsheet");
    }

    public static void swaggerToTestCase()
    {
        String swaggerPath = "src/main/java/testData/testYaml.yml";
        //  Parse the Swagger/OpenAPI spec
        SwaggerParser parser = new SwaggerParser();
        String apiDetails = parser.parseSwagger(swaggerPath);

        // 2. Generate test case outline using LLM
        LLMTestCaseGeneratorFromSwagger llmGen = new LLMTestCaseGeneratorFromSwagger();
        String llmRawOutput = llmGen.generateTestCases(apiDetails);

        // 3. Extract only the Java code from the LLM response

        DataExtractor codeGen = new DataExtractor();

        String finalTestCode = codeGen.extractJavaCode(llmRawOutput);

        //Write generated code to a Cypress file
        FileUtils.writeToFile(finalTestCode, "src/autoGeneratedCodes/RestAssured.java");

        System.out.println("Generated Test cases written to " + " src/autoGeneratedCodes/RestAssured.java");
    }

    public static void voiceToText()
    {
        String voicePath = "src/main/java/testData/TestVoice.m4a";

        // 2. Generate test case outline using LLM
        LLMVoiceToTextGenerator llmGen = new LLMVoiceToTextGenerator();
        String llmRawOutput = llmGen.generateTextFromVoice();
        System.out.println(llmRawOutput);

        DataExtractor codeGen = new DataExtractor();

        String finalText = codeGen.extractVoiceText(llmRawOutput);

        System.out.println(finalText+ "sddfdsf");

        //Write generated code to a Cypress file
        FileUtils.writeToFile(finalText, "src/autoGeneratedCodes/voiceToText.doc");

        System.out.println("Generated Test cases written to " + " src/autoGeneratedCodes/voiceToText.doc");
    }
}
