package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.Booking;
import org.example.ahhomeservice.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/api/getbooking")
    public ResponseEntity<List<Booking>> getall(@RequestParam Long id){
        List<Booking> booking = bookingService.findbyuserid(id);

        return ResponseEntity.ok(booking);

    }


    @PostMapping("/api/booking")
    public Booking createbooking(
            @RequestParam Long userId,
            @RequestParam  String location,
            @RequestParam String workingDate,
            @RequestParam String hoursSpent,
            @RequestParam String instructions,
            @RequestParam Long service_provider_id,
            @RequestParam String paymentStatus
            ){

        return bookingService.createBookingFromCart(userId,location,workingDate, hoursSpent,instructions, service_provider_id, paymentStatus);

    }
}
