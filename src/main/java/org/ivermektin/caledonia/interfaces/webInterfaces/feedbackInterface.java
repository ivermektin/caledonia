package org.ivermektin.caledonia.interfaces.webInterfaces;

import okhttp3.*;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.hygieneInterface;

import java.io.IOException;

/**
 * This class is the feedbackInterface.
 * It sends user-submitted feedback to a Discord Webhook.
 */
public class feedbackInterface {

    /**
     * Sends feedback to a Discord webhook.
     * @param type    the type of feedback (e.g., "Bug Report", "Feature Suggestion", "Review")
     * @param content the content of the feedback message
     * @throws IOException if an error occurs while sending the feedback
     */
    public static void sendFeedback(String type, String content) throws IOException {
        String RED = "16711680";
        String GREEN = "65280";
        String BLUE = "255";

        String color = "0";
        switch (type) {
            case "Bug Report":
                color = RED;
                break;
            case "Feature Suggestion":
                color = GREEN;
                break;
            case "Review":
                color = BLUE;
                break;
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"content\": null,\r\n  \"embeds\": [\r\n    {\r\n      \"title\": \"" + type + "\",\r\n      \"description\": \"" + hygieneInterface.concatenateLines(hygieneInterface.stringSanitizer(content)) + "\",\r\n      \"color\": " + color + ",\r\n      \"author\": {\r\n        \"name\": \"" + "user" + "\"\r\n      }\r\n    }\r\n  ],\r\n  \"attachments\": []\r\n}");
        Request request = new Request.Builder()
                .url("https://discord.com/api/webhooks/1155613376261664908/mJ_5z2LnhTMREmlUYT043Hfv5c4U_K_GLh-LOCRmG73SmPqPvZyDIbAg5pkSx-dFH3DZ")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfruid=74e426dcecaef1c9ce94b83b17d650849d05badd-1695590462; __dcfduid=43cb5b2a5b2011ee88bc3a73e1628286; __sdcfduid=43cb5b2a5b2011ee88bc3a73e1628286eb116ad65709f80f195fba2cf14b8d2ca9a064d0ff2b84aeb152c4b6f16ebb88")
                .build();
        Response response = client.newCall(request).execute();
    }
}
