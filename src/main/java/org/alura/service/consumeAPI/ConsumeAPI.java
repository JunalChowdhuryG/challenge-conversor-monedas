package org.alura.service.consumeAPI;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumeAPI {
    // Stores the API key.
    private final String apikey ;

    // Constructor that initializes the API key and validates it.
    public ConsumeAPI(String apikey) {
        if (apikey == null) { // Validate API key presence.
            throw new IllegalArgumentException("API_KEY is required");
        }
        this.apikey = apikey; // Assign API key.
    }

    // Sends a request to the API and returns the response body.
    public String getRequest() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + this.apikey + "/latest/USD"; // Constructs the URL.
        HttpClient client = HttpClient.newHttpClient(); // Creates an HTTP client.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url)) // Builds the request with the URL.
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString()); // Sends the request and gets the response.
        return response.body(); // Returns the response body.
    }
}
