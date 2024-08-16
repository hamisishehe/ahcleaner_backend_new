package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.AllServices;
import org.example.ahhomeservice.Model.Cart;
import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Repository.AllServiceRepository;
import org.example.ahhomeservice.Repository.CartRepository;
import org.example.ahhomeservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AllServiceRepository allServiceRepository;

    @Autowired
    private UserRepository userRepository;


    public Cart save(Long user , Long service, int price){
        Optional<Cart> existingitem = cartRepository.findByUser_IdAndAllServices_Id(user, service);

        if (existingitem.isPresent()){
            Cart cart1 = existingitem.get();
            cart1.setQuantity(cart1.getQuantity() + 1);
            cart1.setTotal_price(price * cart1.getQuantity());
            return cartRepository.save(cart1);
        }
        else{

            Optional<User> userOptional = userRepository.findById(user);
            Optional<AllServices> serviceOptional = allServiceRepository.findById(service);

            if (userOptional.isPresent() && serviceOptional.isPresent()) {
                Cart newCartItem = new Cart();
                newCartItem.setUser(userOptional.get());
                newCartItem.setAllServices(serviceOptional.get());
                newCartItem.setQuantity(1);
                newCartItem.setTotal_price(price);
                return cartRepository.save(newCartItem);
            } else {

                throw new RuntimeException("User or Service not found");
            }
        }
      
    }

    public List<Cart> getall (Long user_id){
        return cartRepository.findByUser_Id(user_id);
    }

    public void delete(Long id){
        cartRepository.deleteById(id);
    }

}
