package com.example.med.car_location.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.med.car_location.Repository.UserRepository;
import com.example.med.car_location.dto.AuthenticationRequest;
import com.example.med.car_location.dto.AuthenticationResponse;
import com.example.med.car_location.entities.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;



    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername());

        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(r-> {
            roles.add(r.getRole());
        });


        String jwt = JWT.create().
                withSubject(user.getUsername()).
                withArrayClaim("roles", roles.toArray(new String[roles.size()])).
                withExpiresAt(new Date(System.currentTimeMillis()+SecParams.EXP_TIME)).
                sign(Algorithm.HMAC256(SecParams.SECRET));
        response.addHeader("Authorization", jwt);


        return AuthenticationResponse.builder()
                .token(jwt)
                .username(user.getUsername())
                .build();


    }


}
