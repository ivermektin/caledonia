package org.ivermektin.caledonia.services.webServices;

import org.ivermektin.caledonia.services.internalServices.HygieneService;
import org.ivermektin.caledonia.services.webServices.lowLevel.OkHTTPService;

import java.io.IOException;

public class FeedbackService {

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
        String body = "{\r\n  \"content\": null,\r\n  \"embeds\": [\r\n    {\r\n      \"title\": \"" + type + "\",\r\n      \"description\": \"" + HygieneService.concatenateLines(HygieneService.sanitizeString(content)) + "\",\r\n      \"color\": " + color + ",\r\n      \"author\": {\r\n        \"name\": \"" + "user" + "\"\r\n      }\r\n    }\r\n  ],\r\n  \"attachments\": []\r\n}";
        OkHTTPService.makeRequest("https://discord.com/api/webhooks/1155613376261664908/mJ_5z2LnhTMREmlUYT043Hfv5c4U_K_GLh-LOCRmG73SmPqPvZyDIbAg5pkSx-dFH3DZ", body, null).close();
    }
}
