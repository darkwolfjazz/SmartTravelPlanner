package com.smartTravelPlanner.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {


    @Autowired
    private RestTemplate restTemplate;


    @Value("${flightscraper.api.key}")
    private String apiKey;

    @Value("${flightscraper.api.host}")
    private String apiHost;


    @Autowired
    private ObjectMapper objectMapper;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(FlightService.class);

    public String getFlights(String fromEntityId, String toEntityId, String type) {
        String url = String.format(
                "https://%s/flights/search-everywhere?fromEntityId=%s&toEntityId=%s&type=%s",
                apiHost, fromEntityId, toEntityId, type
        );
        //set headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", apiHost);
        httpHeaders.set("x-rapidapi-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        try {
            logger.info("Constructed URL: {}", url);
            logger.info("Headers: {}", httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception ex) {
            logger.error("Error while calling Flight API: {}", ex.getMessage());
            return "Error: Unable to fetch flights. " + ex.getMessage();
        }
    }
    public String getCheapestFlight(String fromEntityId, String toEntityId, String departureDate) {
        String url = String.format(
                "https://%s/flights/cheapest-one-way?fromEntityId=%s&toEntityId=%s&departDate=%s",
                apiHost, fromEntityId, toEntityId, departureDate
        );

        //setup headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", apiHost);
        httpHeaders.set("x-rapidapi-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        try {
            logger.info("Constructed URL: {}", url);
            logger.info("Headers: {}", httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception ex) {
            logger.error("Error while calling Flight API: {}", ex.getMessage());
            return "Error: Unable to fetch flights. " + ex.getMessage();
        }
    }
}
