package com.example.med.car_location.service;

import com.example.med.car_location.Repository.CommentaireRepository;
import com.example.med.car_location.entities.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    public void saveCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
