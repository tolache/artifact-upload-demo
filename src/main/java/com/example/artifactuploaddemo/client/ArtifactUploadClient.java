package com.example.artifactuploaddemo.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class ArtifactUploadClient {

    public static void main(String[] args) {
        String serverUrl = "http://localhost:8080/upload";
        File file = new File("path/to/your/file.txt");

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost uploadFile = new HttpPost(serverUrl);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());

            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);

            HttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity);

            System.out.println("Response: " + responseString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
