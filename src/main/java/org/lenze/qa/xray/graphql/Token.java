package org.lenze.qa.xray.graphql;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;
import org.lenze.qa.properties.XRayProperties;
import org.lenze.qa.xray.map.Authenticate;
import java.io.IOException;
import java.time.Duration;

public class Token {
    public void Generate(String id, String secret) {
        Authenticate authenticate = new Authenticate(id, secret);

        Gson gson = new Gson();
        String authorize = gson.toJson(authenticate);

        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(Duration.ofMinutes(5)).readTimeout(Duration.ofMinutes(5)).writeTimeout(Duration.ofMinutes(5)).build();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(authorize, mediaType);

        Request request = new Request.Builder()
                .url("https://xray.cloud.getxray.app/api/v2/authenticate")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            XRayProperties.xrayToken = responseBody.string();
            XRayProperties.xrayToken = XRayProperties.xrayToken.substring(1, XRayProperties.xrayToken.length()-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}