package org.example.ahhomeservice.Controller;


import org.example.ahhomeservice.Model.Booking;
import org.example.ahhomeservice.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("bookingcontroller")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin/bookings")
    public String getall (Model model){
        List<Booking> bookings =  bookingService.getallbooking();
        model.addAttribute("bookings", bookings);
        return "admin/bookings";
    }
}
