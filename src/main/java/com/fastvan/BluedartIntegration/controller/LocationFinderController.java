package com.fastvan.BluedartIntegration.controller;

import com.fastvan.BluedartIntegration.model.PincodeRequest;
import com.fastvan.BluedartIntegration.service.LocationFinderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LocationFinderController {
    private static final Logger logger = LoggerFactory.getLogger(LocationFinderController.class);
    private final LocationFinderService locationFinderService;

    @Autowired
    public LocationFinderController(LocationFinderService locationFinderService) {
        this.locationFinderService = locationFinderService;
    }

    //Checking if delivery possible on location.
    @PostMapping("/findLocation")
    public ResponseEntity<String> getLocation(@RequestHeader("JWTToken") String jwtToken, @RequestBody PincodeRequest request) {
        try{
            String response = locationFinderService.consumeAPI(jwtToken, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            logger.error("Error finding location", e);
            return new ResponseEntity<>("Failed to find location. Please check the request and try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
