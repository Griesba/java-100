package com.leretvil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {

    private static final String SERVER_URL = "http://localhost:8081/api/books/basket";

    public int sendRequest(String jsonInput) {
        int status = -1;
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            //DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            try (OutputStream os = connection.getOutputStream()){
                byte [] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            status = connection.getResponseCode();
            String message = connection.getResponseMessage();
        } catch ( MalformedURLException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return status;

    }

}
