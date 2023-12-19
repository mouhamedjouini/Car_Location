package com.example.med.car_location.service;



import com.example.med.car_location.entities.Role;
import com.example.med.car_location.entities.User;
import com.example.med.car_location.service.register.RegistationRequest;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> FindAllUsers();
    User registerUser(RegistationRequest request);
    public void sendEmailUser(User u, String code);
    public User validateToken(String code);

}