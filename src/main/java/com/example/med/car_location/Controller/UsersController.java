package com.example.med.car_location.Controller;

import com.example.med.car_location.Repository.UserRepository;
import com.example.med.car_location.entities.User;
import com.example.med.car_location.service.UserService;
import com.example.med.car_location.service.register.RegistationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UsersController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @GetMapping("/allUsers")
    public List<User> allUsers(   ) {

        return userRepository.findAll();
    }
    @PostMapping("/register")
    public User register(@RequestBody RegistationRequest request) {

        return userService.registerUser(request);
    }
    @GetMapping("/verifyEmail/{token}")
    public User verifyEmail(@PathVariable("token") String token){
        return userService.validateToken(token);
    }


}
