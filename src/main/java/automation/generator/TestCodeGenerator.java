package automation.generator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Console;

public class TestCodeGenerator {

    private static final Log log = LogFactory.getLog(TestCodeGenerator.class);

    public String extractTSCode(String llmResponse) {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(llmResponse);
            JsonNode choicesNode = rootNode.path("choices");
            if (choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).path("message");
                String content = messageNode.path("content").asText().trim();
                if (content.contains("```typescript")) {
                    int start = content.indexOf("```typescript");
                    int end = content.lastIndexOf("```");
                    if (start != -1 && end != -1 && end > start) {
                        content = content.substring(start + "```typescript".length(), end).trim();
                    }
                } else if (content.contains("export")) {
                    int index = content.indexOf("export");
                    content = content.substring(index).trim();
                }
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertToJavaCode(llmResponse);
    }

    public String convertToJavaCode(String extractedCode)
    {
        return extractedCode;
    }
}
