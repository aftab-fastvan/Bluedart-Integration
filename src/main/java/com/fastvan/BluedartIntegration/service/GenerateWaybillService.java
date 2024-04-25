package com.fastvan.BluedartIntegration.service;

import com.fastvan.BluedartIntegration.model.GenerateWaybillRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

//@Slf4j
@Service
public class GenerateWaybillService {
    private static final Logger logger = LoggerFactory.getLogger(GenerateWaybillService.class);
    private final RestTemplate restTemplate;

    @Autowired
    public GenerateWaybillService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String consumeAPI(String jwtToken, GenerateWaybillRequest request) {
        String url = "https://apigateway-sandbox.bluedart.com/in/transportation/waybill/v1/GenerateWayBill";

        // Set HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);  // Required Content-Type
        headers.set("JWTToken", jwtToken);  // JWT token for authorization
        headers.set("accept", "application/json");

        // Create HTTP request with headers and request body
        HttpEntity<GenerateWaybillRequest> requestEntity = new HttpEntity<>(request, headers);

        // Send POST request to the endpoint
        try{
            return restTemplate.postForObject(url, requestEntity, String.class);
        }
        catch(RestClientException e){
            logger.error("Error consuming API for generating waybill", e);
            throw new RuntimeException("API consumption failed");
        }

    }
}
