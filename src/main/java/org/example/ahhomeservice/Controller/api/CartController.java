package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.Cart;
import org.example.ahhomeservice.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/api/cart")
    public Cart save(@RequestParam Long user, @RequestParam Long service, @RequestParam int price){
       return cartService.save(user, service, price);

    }

    @GetMapping("/api/allcart/{id}")
    public List<Cart> getall(@PathVariable  Long id){
        return cartService.getall(id);
    }

    @PostMapping("/api/deletecart")
    public void delete(@RequestParam Long id){
        cartService.delete(id);
    }

}
