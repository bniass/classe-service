package com.ecole221.classe.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
//@Table(name = "filiere_table")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 150)
    private String libelle;

    @OneToMany(mappedBy = "filiere")
    private List<Classe> classes;

}
