package com.example.med.car_location.Controller;

import com.example.med.car_location.dto.AuthenticationRequest;
import com.example.med.car_location.dto.AuthenticationResponse;
import com.example.med.car_location.entities.User;
import com.example.med.car_location.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserService uservice;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {

        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/register") // Modification du endpoint pour l'enregistrement
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = uservice.saveUser(user); // Appel de la méthode saveUser du service
        return ResponseEntity.ok(savedUser);}

}
