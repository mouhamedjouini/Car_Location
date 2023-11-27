package com.example.med.car_location.service;

import com.example.med.car_location.Repository.VoitureRepository;
import com.example.med.car_location.entities.Voiture;
import com.example.med.car_location.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoitureServiceImpl implements VoitureService{
    @Autowired
    VoitureRepository voitureRepository;

    public VoitureServiceImpl(VoitureRepository voitureRepository) {
        super();
        this.voitureRepository = voitureRepository;
    }

    @Override
    public Voiture saveVoiture(Voiture v) {
        return voitureRepository.save(v);
    }

    @Override
    public Voiture updateVoiture(Voiture v, long id) {
        Voiture existingVoiture =
                voitureRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Marque",
                                "Id", id));
        existingVoiture.setNomVoiture(v.getNomVoiture());
        existingVoiture.setSerie(v.getSerie());

// save existing employee to DB
        voitureRepository.save(existingVoiture);
        return existingVoiture;
    }

    @Override
    public void deleteVoitureById(long id) {
        voitureRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Voiture", "Id", id));
        voitureRepository.deleteById(id);
    }

    @Override
    public Voiture getVoitureById(long id) {
        return this.voitureRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Voiture","Id",id));
    }




    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }
}
