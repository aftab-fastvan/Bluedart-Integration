package com.fastvan.BluedartIntegration.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TrackShipmentService {
    private final RestTemplate restTemplate;

    public TrackShipmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String trackShipment(String jwtToken, String handler, String loginId, String numbers, String format,
                                String lickey, String scan, String action, String verno, String awb)
    {
        // Build the URL with the query parameters
        String baseUrl = "https://apigateway-sandbox.bluedart.com/in/transportation/tracking/v1/shipment";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("handler", handler)
                .queryParam("loginid", loginId)
                .queryParam("numbers", numbers)
                .queryParam("format", format)
                .queryParam("lickey", lickey)
                .queryParam("scan", scan)
                .queryParam("action", action)
                .queryParam("verno", verno)
                .queryParam("awb", awb);

        // Set HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "text/plain");
        headers.add("JWTToken", jwtToken);

        // Prepare the HTTP request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Send GET request
        ResponseEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class, requestEntity);

        return response.getBody();  // Return the response body as a string
    }
}
