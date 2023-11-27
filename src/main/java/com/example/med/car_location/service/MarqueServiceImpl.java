package com.example.med.car_location.service;

import com.example.med.car_location.Repository.MarqueRepository;
import com.example.med.car_location.entities.Marque;
import com.example.med.car_location.entities.Voiture;
import com.example.med.car_location.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class MarqueServiceImpl implements MarqueService{
    @Autowired
    MarqueRepository marqueRepository;

    public MarqueServiceImpl(MarqueRepository marqueRepository) {
        super();
        this.marqueRepository = marqueRepository;
    }

    @Override
    public Marque saveMarque(Marque m) {
        return marqueRepository.save(m);
    }

    @Override
    public Marque updateMarque(Marque m, long id) {
        Marque existingMarque =
                marqueRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Marque",
                                "Id", id));
        existingMarque.setMarque(m.getMarque());
        existingMarque.setDescriptionMarque(m.getDescriptionMarque());

// save existing employee to DB
        marqueRepository.save(existingMarque);
        return existingMarque;
    }

    @Override
    public void deleteMarqueById(long id) {
        marqueRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Marque", "Id", id));
        marqueRepository.deleteById(id);
    }

    @Override
    public Marque getMarqueById(long id) {
        return this.marqueRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Marque","Id",id));
    }

    @Override
    public List<Marque> getAllMarque() {
        return marqueRepository.findAll();
    }
}
