package automation.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import testData.SampleCodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LLMCodeGeneratorSelToCypress {

    private static final String LLM_API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static final String API_KEY = "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";

    public String generateTScode(String seleniumData) {
        if (seleniumData == null || seleniumData.isEmpty()) {
            return "No valid Selenium code to generate test cases.";
        }
        String userPrompt = "Convert Selenium Java test automation code to Cypress TypeScript while preserving the logic and functionality:\n"
                + seleniumData;
        String example = SampleCodes.seleniumToCypressExample;

        try {
            List<Map<String, String>> messages = new ArrayList<>();
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "Ensure that the converted code follows Cypress's best practices, including:"
                    + "-- Proper async/await usage for handling asynchronous operations."
                    + "-- Selectors conversion (e.g., By.id() → page.locator() equivalent)."
                    + "-- Handling of waits (Implicit/Explicit waits should be replaced with Cypress’s auto-waiting)."
                    + "-- Assertions should be mapped to Cypress’s test assertions if applicable."
                    + "-- Maintain proper TypeScript typings (Page, Browser, etc.) and use ES6+ features where appropriate"
                    + "-- Optimize code structure, removing unnecessary waits or redundant calls."
                    + "-- The output must be idiomatic Cypress TypeScript, not just a direct Java-to-TypeScript translation"
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
