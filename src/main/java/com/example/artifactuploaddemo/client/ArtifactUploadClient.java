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
        if (args.length < 2) {
            System.out.println("Usage: java com.example.artifactuploaddemo.client.ArtifactUploadClient <server-url> <file-path>");
            System.exit(1);
        }

        String serverOrigin = args[0];
        String filePath = args[1];
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            System.exit(1);
        }

        String serverUrl = serverOrigin + "/upload";

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
