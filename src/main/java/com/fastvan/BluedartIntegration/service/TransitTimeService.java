package com.fastvan.BluedartIntegration.service;

import com.fastvan.BluedartIntegration.controller.TransitTimeController;
import com.fastvan.BluedartIntegration.model.TransitTimeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class TransitTimeService {
    private static final Logger logger = LoggerFactory.getLogger(TransitTimeController.class);
    private final RestTemplate restTemplate;

    @Autowired
    public TransitTimeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String consumeAPI(String jwtToken, TransitTimeRequest request) {

        String url = "https://apigateway-sandbox.bluedart.com/in/transportation/transit/v1/GetDomesticTransitTimeForPinCodeandProduct";

        // Set HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // Required Content-Type
        headers.set("JWTToken", jwtToken);  // JWT token for authorization
        headers.set("accept", "application/json");

        // HTTP request with headers and request body
        HttpEntity<TransitTimeRequest> requestEntity = new HttpEntity<>(request, headers);

        // Send POST request to the endpoint
        try {
            return restTemplate.postForObject(url, requestEntity, String.class);
        } catch (RestClientException e) {
            logger.error("Error consuming API for transit time", e);
            throw new RuntimeException("API consumption failed");
        }
    }
}
