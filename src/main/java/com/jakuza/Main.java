package com.jakuza;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        JSONObject userJson = new JSONObject();
        userJson.put("fullName", "John Smith");
        JSONObject applicationJson = new JSONObject();
        applicationJson.put("name", "Need For Speed");

        JSONObject reqJson = new JSONObject();
        reqJson.put("appUser", userJson);
        reqJson.put("application", applicationJson);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/system/basic");

        StringEntity entity = new StringEntity(userJson.toString());
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response);
        client.close();
    }

}
