package com.example.med.car_location.service;

import com.example.med.car_location.entities.Marque;
import com.example.med.car_location.entities.Voiture;

import java.util.List;

public interface VoitureService {
    Voiture saveVoiture(Voiture v);
    Voiture updateVoiture(Voiture v,long id);
    Voiture updateVoiture(Voiture v);
    void deleteVoitureById(long id);
    Voiture getVoitureById(long id);
    List<Voiture> getAllVoiture();
    List<Voiture> findByNomVoiture(String nom);
    List<Voiture> findByNomVoitureContains(String nom);
    List<Voiture> findByNomPrix (String nom, Double prix);
    List<Voiture> findByMarque (Marque marque);
    List<Voiture> findByMarqueIdMar(Long id);
    List<Voiture> findByOrderByNomVoitureAsc();
    List<Voiture> trierVoitureNomsPrix();


}
