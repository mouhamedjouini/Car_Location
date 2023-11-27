package com.example.med.car_location.service;



import com.example.med.car_location.entities.Role;
import com.example.med.car_location.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> FindAllUsers();
}