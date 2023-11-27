package com.example.med.car_location.Controller;

import com.example.med.car_location.Repository.UserRepository;
import com.example.med.car_location.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/allUsers")
    public List<User> allUsers(   ) {

        return userRepository.findAll();
    }


}
