package generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sampleData.Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LLMVoiceToTextGenerator {

    private static final String LLM_API_URL = "https://api.groq.com/openai/v1/audio/transcriptions";
    private static final String API_KEY = "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";

    public String generateTextFromVoice()
    {
        String path = "src/main/java/testData/TestVoice.m4a";
        String userPrompt = "Convert voice file to text\n"
                + path;
        String example = Examples.voiceToTextExample;

        try {
            List<Map<String, String>> messages = new ArrayList<>();
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "Instruction :Please provide a simple Voice to text conversion for the attached voice recording present in"
                    + path
                    + "-- Context : I am preparing a platform to automatically convert Voice Commands to Text Instructions"
                    + example
                    + "-- Output should be in word format");

            messages.add(systemMessage);
            Map<String, String> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", userPrompt);
            messages.add(userMessage);
            Map<String, Object> payload = new HashMap<>();
            payload.put("model", "whisper-large-v3");
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
