package com.example.med.car_location.service;

import com.example.med.car_location.entities.Marque;
import com.example.med.car_location.entities.Voiture;

import java.util.List;

public interface MarqueService {
    Marque saveMarque(Marque m);
    Marque updateMarque(Marque m,long id);

    void deleteMarqueById(long id);
    Marque getMarqueById(long id);
    List<Marque> getAllMarque();
}
