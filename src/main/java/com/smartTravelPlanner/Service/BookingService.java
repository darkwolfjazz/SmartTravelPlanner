package com.smartTravelPlanner.Service;

import com.smartTravelPlanner.Entity.BookingEntity;
import com.smartTravelPlanner.Entity.UserEntity;
import com.smartTravelPlanner.Repository.BookingRepository;
import com.smartTravelPlanner.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {


    @Autowired
    private BookingRepository bookingRepository;


public String makeBooking(BookingEntity booking){
    bookingRepository.save(booking);
    return "Booking successful";
}


}
