package com.smartTravelPlanner.Controller;

import com.smartTravelPlanner.Service.FlightService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

@Autowired
    private FlightService flightService;

private Logger logger=org.slf4j.LoggerFactory.getLogger(FlightController.class);

@GetMapping("/search-everywhere")
    public String getFlights(@RequestParam String fromEntityId,
                             @RequestParam String toEntityId,
                             @RequestParam String type) {
    logger.info("Received flight search request for fromEntityId: " +
            "{}, toEntityId: {}, type: {}", fromEntityId, toEntityId, type);
    return flightService.getFlights(fromEntityId, toEntityId, type);
}


@GetMapping("/cheapest-one-way")
    public String getCheapestFlight(@RequestParam String fromEntityId,
                                    @RequestParam String toEntityId,
                                    @RequestParam String departureDate) {
        logger.info("Received flight search request for fromEntityId: " +
                "{}, toEntityId: {}, departureDate: {}", fromEntityId, toEntityId, departureDate);
        return flightService.getCheapestFlight(fromEntityId, toEntityId, departureDate);
    }
}
