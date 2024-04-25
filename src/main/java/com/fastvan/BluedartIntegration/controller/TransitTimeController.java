package com.fastvan.BluedartIntegration.controller;

import com.fastvan.BluedartIntegration.model.TransitTimeRequest;
import com.fastvan.BluedartIntegration.service.TransitTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransitTimeController {
    private static final Logger logger = LoggerFactory.getLogger(TransitTimeController.class);
    private final TransitTimeService transitTimeService;

    @Autowired
    public TransitTimeController(TransitTimeService transitTimeService) {
        this.transitTimeService = transitTimeService;
    }

    //getting transit time details
    @PostMapping("/getTransitTime")
    public ResponseEntity<String> getTransitTime(@RequestHeader("JWTToken") String jwtToken, @RequestBody TransitTimeRequest request) {
        try {
            String response = transitTimeService.consumeAPI(jwtToken, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting transit time", e);
            return new ResponseEntity<>("Failed to get transit time. Please check the request and try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
