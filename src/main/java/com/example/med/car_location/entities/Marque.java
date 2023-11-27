package com.example.med.car_location.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMar;
    private String Marque;
    private String descriptionMarque;
    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<Voiture> Voitures;

}
