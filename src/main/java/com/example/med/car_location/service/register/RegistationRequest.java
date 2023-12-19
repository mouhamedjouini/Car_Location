package com.example.med.car_location.service.register;

import com.example.med.car_location.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegistationRequest {
    private String username;
    private String password;
    private String email;

}
