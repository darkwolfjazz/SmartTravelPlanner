package com.smartTravelPlanner.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long booking_id;

@ManyToOne
@JoinColumn(name = "user_id")
private UserEntity user;
private String travellerName;
private String travellerEmail;
private double price;
private String travelMode;
private String hoelName;
private int age;
private int noOfAdults;


}
