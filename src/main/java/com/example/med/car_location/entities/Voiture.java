package com.example.med.car_location.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;

    @Column(name = "nomVoiture", nullable = false)
    private String nomVoiture;
    @Column(name = "prixVoiture")
    private Double prixVoiture;
    @Column(name = "serie")
    private String serie;
    @Column(name = "dateMiseEnCirculation")
    private LocalDate dateMiseEnCirculation;
    @ManyToOne
    private Marque marque;

    public String getNomVoiture() {
        return nomVoiture;
    }

    public void setNomVoiture(String nomVoiture) {
        this.nomVoiture = nomVoiture;
    }
}
