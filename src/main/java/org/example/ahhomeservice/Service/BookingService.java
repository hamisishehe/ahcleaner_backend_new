package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.Booking;
import org.example.ahhomeservice.Model.BookingServiceModel;
import org.example.ahhomeservice.Model.Cart;
import org.example.ahhomeservice.Model.ServiceProvider;
import org.example.ahhomeservice.Repository.BookingRepository;
import org.example.ahhomeservice.Repository.CartRepository;
import org.example.ahhomeservice.Repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findbyuserid(Long userid) {
        return bookingRepository.findByUser_Id(userid);
    }

    public Long countall(){
        Long count = bookingRepository.count();
        return count;
    }

    public List<Booking> getallbooking() {
        return bookingRepository.findAll();
    }


    public Booking createBookingFromCart(Long userId, String location, String workingDate, String hoursSpent, String instructions, Long service_provider_id, String paymentStatus) {

        List<Cart> cartItems = cartRepository.findByUser_Id(userId);

        ServiceProvider serviceProvider = serviceProviderRepository.findById(service_provider_id)
                .orElseThrow(() -> new RuntimeException("ServiceProvider not found"+service_provider_id));


        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }



        Booking booking = new Booking();
        booking.setUser(cartItems.get(0).getUser());
        booking.setLocation(location);
        booking.setWorkingDate(workingDate);
        booking.setHoursspend(hoursSpent);
        booking.setInstructions(instructions);
        booking.setServiceProvider(serviceProvider);
        booking.setStatus(Booking.Status.PENDING);
        booking.setPaymentstatus(Booking.PaymentStatus.valueOf(paymentStatus));
        booking.setTotal_amount(cartItems.stream().mapToDouble(cartItem -> cartItem.getTotal_price()).sum());

        Set<BookingServiceModel> BookingServiceModel = cartItems.stream().map(cartItem -> {
            BookingServiceModel bookingServiceModel = new BookingServiceModel();
            bookingServiceModel.setBooking(booking);
            bookingServiceModel.setAllServices(cartItem.getAllServices());
            bookingServiceModel.setQuantity(cartItem.getQuantity());
            return bookingServiceModel;
        }).collect(Collectors.toSet());

        booking.setBookingServiceModels(BookingServiceModel);
        Booking savedBooking = bookingRepository.save(booking);

        // Clear the cart after booking
        cartRepository.deleteAll(cartItems);

        return savedBooking;
    }
    
}
