package com.fastvan.BluedartIntegration.controller;

import com.fastvan.BluedartIntegration.service.TrackShipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackShipmentController {
    private final TrackShipmentService trackShipmentService;

    public TrackShipmentController(TrackShipmentService trackShipmentService) {
        this.trackShipmentService = trackShipmentService;
    }

    @GetMapping("/trackShipment")
    public String getTrackingDetails(
            @RequestHeader("JWTToken") String jwtToken,
            @RequestParam("handler") String handler,
            @RequestParam("loginid") String loginId,
            @RequestParam("numbers") String numbers,
            @RequestParam("format") String format,
            @RequestParam("lickey") String lickey,
            @RequestParam("scan") String scan,
            @RequestParam("action") String action,
            @RequestParam("verno") String verno,
            @RequestParam("awb") String awb
    ) {
        return trackShipmentService.trackShipment(jwtToken, handler, loginId, numbers, format, lickey, scan, action, verno, awb);
    }
}
