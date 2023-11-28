package com.example.med.car_location.Repository;

import com.example.med.car_location.entities.Marque;
import com.example.med.car_location.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    List<Voiture> findByNomVoiture(String nom);
    List<Voiture> findByNomVoitureContains(String nom);
    @Query("select v from Voiture v where v.nomVoiture like %:nom and v.prixVoiture > :prix")
    List<Voiture> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);
    @Query("select m from Marque  m where m.Marque = ?1")
    List<Voiture> findByMarque (Marque marque);
    List<Voiture> findByMarqueIdMar(Long id);
    List<Voiture> findByOrderByNomVoitureAsc();
    @Query("select p from Voiture p order by p.nomVoiture ASC, p.prixVoiture DESC")
    List<Voiture> trierVoitureNomsPrix ();

}
