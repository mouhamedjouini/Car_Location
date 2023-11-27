package com.example.med.car_location.Repository;

import com.example.med.car_location.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque,Long> {
}
