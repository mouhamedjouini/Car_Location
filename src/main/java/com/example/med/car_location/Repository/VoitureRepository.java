package com.example.med.car_location.Repository;

import com.example.med.car_location.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
