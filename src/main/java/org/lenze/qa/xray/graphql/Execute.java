package org.lenze.qa.xray.graphql;

import okhttp3.*;
import org.json.JSONObject;

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
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiY2YyYzgzMi00NjljLTM2ZTMtOGE5Mi00NTVkM2ZkYWM0NDMiLCJhY2NvdW50SWQiOiI1NTcwNTg6MmNhMzRhYWItZjc1ZC00MzUzLTg1ZTAtOTJkZDA3MmFhMWY0IiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE2ODA2NzI5ODUsImV4cCI6MTY4MDc1OTM4NSwiYXVkIjoiQzYyM0NDMEE4MkM2NDJGOTlBMkFBMDYwODk5NkQxMUYiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiJDNjIzQ0MwQTgyQzY0MkY5OUEyQUEwNjA4OTk2RDExRiJ9.7v24zmP6xpQ2Lm_vss1_Qsf2Qq7SJnjEVFgdyKFeSRk")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
