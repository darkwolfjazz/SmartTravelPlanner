package com.smartTravelPlanner.Controller;

import com.smartTravelPlanner.Entity.BookingEntity;
import com.smartTravelPlanner.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

@Autowired
private BookingService bookingService;


@PostMapping("/booking")
    public String doBooking(@RequestBody BookingEntity booking){
        bookingService.makeBooking(booking);
        return "Booking successful";
}
}
