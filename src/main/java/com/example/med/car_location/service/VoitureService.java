package com.example.med.car_location.service;

import com.example.med.car_location.entities.Voiture;

import java.util.List;

public interface VoitureService {
    Voiture saveVoiture(Voiture v);
    Voiture updateVoiture(Voiture v,long id);

    void deleteVoitureById(long id);
    Voiture getVoitureById(long id);
    List<Voiture> getAllVoiture();
}
