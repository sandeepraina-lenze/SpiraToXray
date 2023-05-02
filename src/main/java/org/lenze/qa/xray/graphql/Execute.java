package org.lenze.qa.xray.graphql;

import okhttp3.*;
import org.json.JSONObject;
import org.lenze.qa.properties.XRayProperties;

import java.io.IOException;
import java.time.Duration;

public class Execute {
    public void Migrate(String graphqlQuery) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", graphqlQuery);

        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(Duration.ofMinutes(5)).readTimeout(Duration.ofMinutes(5)).writeTimeout(Duration.ofMinutes(5)).build();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);

        Request request = new Request.Builder()
                .url("https://xray.cloud.getxray.app/api/v2/graphql")
                .post(body)
                .addHeader("Authorization", "Bearer " + XRayProperties.xrayToken)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String currentResponse = response.body().string();

            if (response.code() != 200) {
                XRayProperties.writeLog.write(graphqlQuery + "\r\n");
                XRayProperties.writeLog.write(currentResponse + "\r\n");
                XRayProperties.writeLog.flush();
            }

            System.out.println(currentResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
