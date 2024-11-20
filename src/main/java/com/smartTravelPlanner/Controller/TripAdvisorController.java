package com.smartTravelPlanner.Controller;

import com.smartTravelPlanner.Service.TripAdvisorService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tripadvisor")
public class TripAdvisorController {

@Autowired
    private TripAdvisorService tripAdvisorService;


private Logger logger=org.slf4j.LoggerFactory.getLogger(TripAdvisorController.class);

    @GetMapping("/hotels/searchHotelsByLocation")
    public ResponseEntity<?> searchHotelsByLocation(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int pageNumber,
            @RequestParam String currencyCode,
            @RequestParam String checkIn,
            @RequestParam String checkOut) {
        // Calling service layer


        logger.info("Received request for latitude: {}, longitude: {}, pageNumber: {}, currencyCode: {}",
                latitude, longitude, pageNumber, currencyCode);


        return ResponseEntity.ok(tripAdvisorService.
                getHotelsByLocation(latitude, longitude, pageNumber, currencyCode,checkIn,checkOut));
    }
}
