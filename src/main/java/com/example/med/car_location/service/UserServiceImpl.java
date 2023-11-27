package com.example.med.car_location.service;

import com.example.med.car_location.Repository.RoleRepository;
import com.example.med.car_location.Repository.UserRepository;
import com.example.med.car_location.entities.Role;
import com.example.med.car_location.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepository userRep;

    @Autowired
    RoleRepository roleRep;


    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);

        usr.getRoles().add(r);
        return usr;
    }

    @Override
    public List<User> FindAllUsers() {
        return userRep.findAll();
    }


    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }

}

