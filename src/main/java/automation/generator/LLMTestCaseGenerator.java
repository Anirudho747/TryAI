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

public class LLMTestCaseGenerator {

    private static final String LLM_API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static final String API_KEY = "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";

    public String generateTestcases(String jiraStory)
    {
        if (jiraStory == null || jiraStory.isEmpty())
        {
            return "No valid Jira Story to generate test cases.";
        }
        String userPrompt = "Generate Test cases from provided Jira Stories while preserving the logic and functionality:\n"
                + jiraStory;
        String example = SampleCodes.jiraToTestCaseExample;

        try {
            List<Map<String, String>> messages = new ArrayList<>();
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "I am preparing a platform to directly change a Story to relevant test cases. I  cannot afford any Test case to be missed out"
                    + example
                    +"-- Output :   The output must be in a csv format\n"
                    +"Persona : You are a Manual tester having a decade of experience in Functional, Performance, API & Security testing. You are in PIP and a single missed test casein lead to job loss");
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
