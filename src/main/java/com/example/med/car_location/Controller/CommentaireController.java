package com.example.med.car_location.Controller;

import com.example.med.car_location.entities.Commentaire;
import com.example.med.car_location.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/commentaires/{id}")
    public Commentaire getCommentaireById(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id);
    }

    @PostMapping
    public void saveCommentaire(@RequestBody Commentaire commentaire) {
        commentaireService.saveCommentaire(commentaire);
    }

    @PutMapping("/commentaires/{id}")
    public void updateCommentaire(@PathVariable Long id, @RequestBody Commentaire updatedCommentaire) {
        Commentaire existingCommentaire = commentaireService.getCommentaireById(id);
        if (existingCommentaire != null) {
            existingCommentaire.setContenu(updatedCommentaire.getContenu());
            existingCommentaire.setId_user(updatedCommentaire.getId_user());
            commentaireService.saveCommentaire(existingCommentaire);
        }
    }

    @DeleteMapping("/commentaires/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
    }
}

