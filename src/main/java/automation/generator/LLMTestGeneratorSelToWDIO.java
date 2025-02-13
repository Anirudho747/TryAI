package automation.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LLMTestGeneratorSelToWDIO {

    private static final String LLM_API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static final String API_KEY = "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";

    public String generateTestCases(String seleniumData) {
        if (seleniumData == null || seleniumData.isEmpty()) {
            return "No valid Selenium code to generate test cases.";
        }
        String userPrompt = "Convert Selenium Java test automation code to WDIO TypeScript while preserving the logic and functionality:\n"
                + seleniumData;
        String example = "\tExample:\n" +
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

        try {
            List<Map<String, String>> messages = new ArrayList<>();
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "Ensure that the converted code follows WDIO’s best practices, including "
                    + "-- Proper async/await usage for handling asynchronous operations."
                    + "-- Selectors conversion (e.g., By.id() → page.locator() equivalent)."
                    + "-- Handling of waits (Implicit/Explicit waits should be replaced with WDIO’s auto-waiting)."
                    + "-- Assertions should be mapped to WDIO’s test assertions if applicable."
                    + "-- Maintain proper TypeScript typings (Page, Browser, etc.) and use ES6+ features where appropriate"
                    + "-- Optimize code structure, removing unnecessary waits or redundant calls."
                    + "-- The output must be idiomatic WDIO TypeScript, not just a direct Java-to-TypeScript translation"
                    + "-- DO NOT add any additional steps other than given input code"
                    + "-- Disable strict mode violation when finding locators"
                    + "-- Example: "+example);

            messages.add(systemMessage);
            Map<String, String> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", userPrompt);
            messages.add(userMessage);
            Map<String, Object> payload = new HashMap<>();
            payload.put("model", "deepseek-r1-distill-llama-70b");
            payload.put("messages", messages);
            payload.put("temperature", 0.2);
   //         payload.put("max_tokens", 1500);
            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(payload);
            return callLLMApi(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error building JSON payload: " + e.getMessage();
        }
    }

    private String callLLMApi(String requestBody) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(LLM_API_URL);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Authorization", "Bearer " + API_KEY);
            request.setEntity(new StringEntity(requestBody));
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling LLM API: " + e.getMessage();
        }
    }
}
