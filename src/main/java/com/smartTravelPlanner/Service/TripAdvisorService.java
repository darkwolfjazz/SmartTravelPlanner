package com.smartTravelPlanner.Service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripAdvisorService {


@Autowired
    private RestTemplate restTemplate;



private Logger logger=org.slf4j.LoggerFactory.getLogger(TripAdvisorService.class);

 @Value("${tripadvisor.api.key}")
 private String apiKey;

 @Value("${tripadvisor.api.host}")
 private String apiHost;

    public String getHotelsByLocation(double latitude, double longitude, int pageNumber
            , String currencyCode,String checkIn,String checkOut) {
        // Construct the API URL
        String url = String.format(
                "https://%s/api/v1/hotels/searchHotelsByLocation?latitude=%f&longitude=%f&checkIn=%s&checkOut=%s&pageNumber=%d&currencyCode=%s",
                apiHost, latitude, longitude, checkIn, checkOut, pageNumber, currencyCode
        );

        // Set headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-RapidAPI-Host", apiHost);
        httpHeaders.set("X-RapidAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        try {
            logger.info("Constructed URL: {}", url);
            logger.info("Headers: {}", httpHeaders);
            // Call the TripAdvisor API
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            //logger.info("Response Status: {}", response.getStatusCode());
            //logger.info("Response Body: {}", response.getBody());
            return response.getBody();
        } catch (Exception ex) {
            logger.error("Error while calling TripAdvisor API: {}", ex.getMessage());
            return "Error: Unable to fetch hotels. " + ex.getMessage();
        }
    }
}
