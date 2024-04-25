package com.fastvan.BluedartIntegration.controller;

import com.fastvan.BluedartIntegration.model.GenerateWaybillRequest;
import com.fastvan.BluedartIntegration.service.GenerateWaybillService;
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
public class GenerateWaybillController {
    private static final Logger logger = LoggerFactory.getLogger(GenerateWaybillController.class);
    private final GenerateWaybillService waybillService;

    @Autowired
    public GenerateWaybillController(GenerateWaybillService waybillService) {
        this.waybillService = waybillService;
    }

    //Generating waybill. This will take care of registering for pickup, label and manifest generation.
    @PostMapping("/generateWaybill")
    public ResponseEntity<String> generateWaybill(@RequestHeader("JWTToken") String jwtToken, @RequestBody GenerateWaybillRequest waybillRequest) {
        try{
            String response = waybillService.consumeAPI(jwtToken, waybillRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            logger.error("Error generating waybill",e);
            return new ResponseEntity<>("Failed to generate waybill. Please check the request and try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
