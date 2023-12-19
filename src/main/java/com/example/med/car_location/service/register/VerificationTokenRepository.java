package com.example.med.car_location.service.register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long>{
    VerificationToken findByToken(String token);

}