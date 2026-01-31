package com.smartTravelPlanner.ServiceTest;

import com.smartTravelPlanner.Entity.BookingEntity;
import com.smartTravelPlanner.Repository.BookingRepository;
import com.smartTravelPlanner.Service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @InjectMocks
    BookingService bookingService;

    @Test
    void makeBookingTest(){
        BookingEntity fakeBooking=new BookingEntity();
        fakeBooking.setTravellerName("Rahul");
        fakeBooking.setBooking_id(2L);
        fakeBooking.setNoOfAdults(2);
        String result=bookingService.makeBooking(fakeBooking);
        Assertions.assertEquals("Booking successful",result);

    }



}
