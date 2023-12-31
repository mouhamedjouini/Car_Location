package com.example.med.car_location.service;

import com.example.med.car_location.Repository.AvisRepository;
import com.example.med.car_location.entities.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AvisService {

    @Autowired
    private AvisRepository avisRepository;

    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    public Avis getAvisById(Long id) {
        return avisRepository.findById(id).orElse(null);
    }

    public void saveAvis(Avis avis) {
        avisRepository.save(avis);
    }

    public void deleteAvis(Long id) {
        avisRepository.deleteById(id);
    }
}
