package com.ecole221.classe.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 150)
    private String libelle;

    private int fraisInscription;
    private int mensualite;
    private int autreFrais;
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
}
