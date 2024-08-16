package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserControllerApi {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/api/registration")
    public User registration(User user,  String email,  String password, String username, Integer phonenumber){
        return userService.registration(user,email,password,username,phonenumber);
    }


    @GetMapping("/api/userDetails/{email}")
    public Optional<User> getuserDetails(@PathVariable  String email){
        return userService.userDetails(email);
    }

    @PostMapping("/api/user")
    public ResponseEntity<Optional<User>> userdetails(@RequestParam String email){
        Optional<User> user = userService.userDetails(email);
        return ResponseEntity.ok(user);
    }
}
