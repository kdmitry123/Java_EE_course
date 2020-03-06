package by.pvt.client;

import org.springframework.http.StreamingHttpOutputMessage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String body = "{\n" +
                "  \"name\": \"HUAWEI 9\",\n" +
                "  \"price\": 299.99\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://localhost:8080/product"))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code = " + response.statusCode());
        System.out.println("Response body = " + response.body());
    }
}
