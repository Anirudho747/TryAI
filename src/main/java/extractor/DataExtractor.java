package extractor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataExtractor {

    private static final Log log = LogFactory.getLog(DataExtractor.class);

    public String extractTSCode(String llmResponse) {
        String content="";
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(llmResponse);
            JsonNode choicesNode = rootNode.path("choices");
            if (choicesNode.isArray() && choicesNode.size() > 0)
            {
                JsonNode messageNode = choicesNode.get(0).path("message");
                content = messageNode.path("content").asText().trim();
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
              //  System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return convertToJavaCode(llmResponse);
        return(content);
    }

    public String extractTestCase(String llmResponse) {
        String content="";
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(llmResponse);
            JsonNode choicesNode = rootNode.path("choices");
            if (choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).path("message");
                content = messageNode.path("content").asText().trim();
                if (content.contains("Serial Number")) {
                    int start = content.indexOf("Serial Number");
                    int end = content.lastIndexOf("Serial Number");
                    if (start != -1 && end != -1 && end > start) {
                        content = content.substring(start + "```testcases".length(), end).trim();
                    }
                } else if (content.contains("Test Case")) {
                    int index = content.indexOf("Test Case");
                    content = content.substring(index).trim();
                }
                //    System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return convertToJavaCode(llmResponse);
        return(content);
    }

    public String extractJavaCode(String llmResponse) {
        String content="";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(llmResponse);
            JsonNode choicesNode = rootNode.path("choices");
            if (choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).path("message");
                content = messageNode.path("content").asText().trim();
                if (content.contains("```java")) {
                    int start = content.indexOf("```java");
                    int end = content.lastIndexOf("```");
                    if (start != -1 && end != -1 && end > start) {
                        content = content.substring(start + "```java".length(), end).trim();
                    }
                } else if (content.contains("package")) {
                    int index = content.indexOf("package");
                    content = content.substring(index).trim();
                }
                //  System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//
        return(content);
    }

    public String extractVoiceText(String llmResponse) {
        System.out.println(llmResponse + "fgnsdjgg");
        String content="";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(llmResponse);
            JsonNode choicesNode = rootNode.path("choices");
            System.out.println(choicesNode+ "ffvbdhdsbfh");
            if (choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).path("message");
                content = messageNode.path("content").asText().trim();
                System.out.println(content+"vdsvvdf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//
        return(content);
    }

    public String convertToJavaCode(String extractedCode)
    {
        return extractedCode;
    }
}
