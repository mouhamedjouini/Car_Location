package com.example.med.car_location.Repository;

import com.example.med.car_location.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AvisRepository extends JpaRepository<Avis, Long> {
}
