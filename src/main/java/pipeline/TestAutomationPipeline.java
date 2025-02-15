package pipeline;

import automation.generator.LLMTestGeneratorSelToWDIO;
import automation.generator.LLMTestGeneratorSelToPlaywright;
import automation.generator.LLMTestGeneratorSelToCypress;
import automation.generator.TestCodeGenerator;
import testData.SampleCodes;

import java.util.Scanner;

public class TestAutomationPipeline {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select your relevant option");
        System.out.println("1 : Selenium Java to WDIO TS");
        System.out.println("2 : Selenium Java to Playwright TS");
        System.out.println("3 : Selenium Java to Cypress TS");
        int option  = sc.nextInt();
        switch (option) {
            case 1:
                seleniumToWebDriverIO(SampleCodes.userCode);
                break;
            case 2:
                seleniumToPlayWright(SampleCodes.userCode);
                break;
            case 3:
                seleniumToCypress(SampleCodes.userCode);
                break;
            default:
                System.out.println("Please choose relevant options only");
        }

    }

    public static void seleniumToWebDriverIO(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToWDIO llmGen = new LLMTestGeneratorSelToWDIO();
        String llmRawOutput = llmGen.generateTestCases(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        System.out.println("Generated test code is " );
        codeGen.extractTSCode(llmRawOutput);
    }

    public static void seleniumToPlayWright(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToPlaywright llmGen = new LLMTestGeneratorSelToPlaywright();
        String llmRawOutput = llmGen.generateTScode(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        System.out.println("Generated test code is " );
        codeGen.extractTSCode(llmRawOutput);
    }

    public static void seleniumToCypress(String originalCode)
    {
        // Generate test case outline using LLM
        LLMTestGeneratorSelToCypress llmGen = new LLMTestGeneratorSelToCypress();
        String llmRawOutput = llmGen.generateTScode(originalCode);

        // Extract only the Java code from the LLM response
        TestCodeGenerator codeGen = new TestCodeGenerator();
        System.out.println("Generated test code is " );
        codeGen.extractTSCode(llmRawOutput);
    }
}
