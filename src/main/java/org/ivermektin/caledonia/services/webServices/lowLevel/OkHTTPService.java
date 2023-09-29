package org.ivermektin.caledonia.services.webServices.lowLevel;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHTTPService {

    private static OkHttpClient client = new OkHttpClient().newBuilder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .build();

    /**
     * @implNote Does not close response automatically, must be done by caller class
     */
    public static Response makeRequest(String url, String requestBody, Map<String, String> headers) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json");

        for (Map.Entry<String, String> header: headers.entrySet()) {
            requestBuilder.addHeader(header.getKey(), header.getValue());
        }

        Request request = requestBuilder.build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
