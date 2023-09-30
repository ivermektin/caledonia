package org.ivermektin.caledonia.services.webServices;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.ivermektin.caledonia.services.internalServices.HygieneService;
import org.ivermektin.caledonia.services.internalServices.objects.Data;
import org.ivermektin.caledonia.services.systemServices.FilesystemService;
import okhttp3.*;
import org.ivermektin.caledonia.services.webServices.lowLevel.OkHTTPService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AIService {
    private static final String API_KEY = FilesystemService.readFile("apikey.txt").get(0);
    private static final String CONTEXT =  "Use notes to develop a deeper understanding of the user and process the user's notes to develop an understanding of their goals. Use concepts that the user has an established understanding of based off their notes.\n\nOther Notes may contain information about the Subject matter, such as a syllabus/curriculum or project objectives. Make sure to use this information to guide you in creating a response, but do not attribute this content to the user or assume that the user already understands the content.\n\n\n\nWhen creating a response, ensure there are no hallucinations and try your best to provide accurate information. If you are unsure about the accuracy of your response, ensure that it is communicated to the user, and suggest they conduct more research if need be.\n\nMake sure to answer the user's prompt first and foremost.";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final Gson jsonParser = new Gson();
    public static Data generateReport(String prompt, ArrayList<Data> notes, String courseName) throws IOException {
        String noteData = "";
        String oldP = prompt;
        prompt = HygieneService.sanitizeString(prompt);
        for (Data data: notes) {
            noteData += data.getTitle() + " at " + data.getDate() + "\\n" + data.getContent() + "\\n\\n";
        }
        String cleanNoteData = HygieneService.sanitizeString(noteData);
        String contentRequestContext = "The user has made the following notes on " + courseName + ". \n" + cleanNoteData + CONTEXT;
        String content = getContent(makeRequest(contentRequestContext, prompt));
        return new Data(oldP, "Caledonia", content);
    }
    public static String getContent(Response response) throws IOException {
        String responseTXT = response.body().string();
        JsonObject responseJsonObject = jsonParser.fromJson(responseTXT, JsonObject.class);
        response.close();
        if(response.isSuccessful()){
            String content = responseJsonObject.get("choices").getAsJsonArray().get(0).getAsJsonObject().get("message").getAsJsonObject().get("content").getAsString();
            return content;
        } else {
            switch(response.code()) {
                case 401:
                    return "Error 401: Check if your API key is valid.";
                case 429:
                    return "Error 429: You are being ratelimited. Wait 30 seconds.";
                case 500:
                    return "Error 500: OpenAI is currently having server trouble. Wait 30 seconds.";
                case 503:
                    return "Error 503: OpenAI is currently overloaded. Please try again later.";
                default:
                    return "Error " + response.code() + ": " + responseJsonObject.get("error").getAsJsonObject().get("message").getAsString();
            }
        }
    }
    public static Response makeRequest(String context, String prompt) throws IOException {
        String requestBody = ("{\r\n  \"model\": \"gpt-3.5-turbo-16k\",\r\n  \"messages\": [\r\n    {\r\n      \"role\": \"system\",\r\n      \"content\": \"" + context + "\"\r\n    },\r\n    {\r\n      \"role\": \"user\",\r\n      \"content\": \"" + prompt + "\"\r\n    }\r\n  ],\r\n  \"temperature\": 1,\r\n  \"max_tokens\": 2048,\r\n  \"top_p\": 1,\r\n  \"frequency_penalty\": 0,\r\n  \"presence_penalty\": 0.5\r\n}");
        requestBody = HygieneService.concatenateLines(requestBody);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + API_KEY);

        return OkHTTPService.makeRequest(API_URL, requestBody, headers);
    }
}
