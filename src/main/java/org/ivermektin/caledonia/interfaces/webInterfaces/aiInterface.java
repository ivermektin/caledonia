package org.ivermektin.caledonia.interfaces.webInterfaces;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.hygieneInterface;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data;
import org.ivermektin.caledonia.interfaces.systemInterfaces.filesystemInterface;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This class is the aiInterface.
 * It provides an interface for interacting with an AI model to generate reports based on user prompts and notes.
 * It utilizes the OpenAI GPT-3.5 Turbo model to generate responses.
 */
public class aiInterface {
    static String apiKey = filesystemInterface.readFile("apikey.txt").get(0);

    /**
     * Generates a report based on the user prompt, notes, and course name.
     *
     * @param prompt      the user prompt for generating the report
     * @param notes       the list of notes to include in the report
     * @param courseName  the name of the course for which the report is generated
     * @return            a data object representing the generated report
     * @throws IOException if an error occurs during the generation of the report
     */
    public static data generateReport(String prompt, ArrayList<data> notes, String courseName) throws IOException {
        String noteData = "";
        prompt = hygieneInterface.stringSanitizer(prompt);
        for (data data: notes) {
            noteData += data.getTitle() + " at " + data.getDate() + "\\n" + data.getContent() + "\\n\\n";
        }
        String cleanNoteData = hygieneInterface.stringSanitizer(noteData);
        String contentRequestContext = "The user has made the following notes on " + courseName + ". \n" + cleanNoteData + "Most Notes will be study notes. Use this to develop a deeper understanding of the user and process the user's notes to develop an understanding of their learning patterns. Use concepts that the user has an established understanding of based off their notes.\n\nOther Notes may contain information about the course, such as a syllabus/curriculum or learning objectives. Make sure to use this information to guide you in creating a response, but do not attribute this content to the user or assume that the user already understands the content.\n\nFor example, if a learning objective is 1A.4 - Understand the Krebs Cycle, consider if the student's notetaking is demonstrating that they have achieved their learning objective. If not, consider how that objective can be met, factoring in the student's learning patterns.\n\nWhen creating a response, ensure there are no hallucinations and try your best to provide accurate information. If you are unsure about the accuracy of your response, ensure that it is communicated to the user, and suggest they conduct more research if need be.\n\nMake sure to answer the user's prompt first and foremost.";
        String content = getContent(makeRequest(contentRequestContext, prompt));
        return new data(prompt, "Caledonia", content);
    }

    /**
     * Extracts the content from the response received from the AI model.
     *
     * @param response  the OkHttp response object received from the AI model
     * @return          the content extracted from the response
     * @throws IOException if an error occurs during the extraction of the content
     */
    public static String getContent(Response response) throws IOException {
        String responseTXT = response.body().string();
        Gson JSONParser = new Gson();
        JsonObject responseJsonObject = new Gson().fromJson(responseTXT, JsonObject.class);
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

    /**
     * Makes a request to the AI model using the provided context and prompt.
     *
     * @param context  the context in which the prompt is given
     * @param prompt   the user prompt for generating a response
     * @return         the response received from the AI model
     * @throws IOException if an error occurs during the request
     */
    public static Response makeRequest(String context, String prompt) throws IOException {
        String requestBody = ("{\r\n  \"model\": \"gpt-3.5-turbo\",\r\n  \"messages\": [\r\n    {\r\n      \"role\": \"system\",\r\n      \"content\": \"" + context + "\"\r\n    },\r\n    {\r\n      \"role\": \"user\",\r\n      \"content\": \"" + prompt + "\"\r\n    }\r\n  ],\r\n  \"temperature\": 1,\r\n  \"max_tokens\": 2048,\r\n  \"top_p\": 1,\r\n  \"frequency_penalty\": 0,\r\n  \"presence_penalty\": 0.5\r\n}");
        requestBody = hygieneInterface.concatenateLines(requestBody);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }
}
