package com.example.med.car_location.Repository;

import com.example.med.car_location.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
