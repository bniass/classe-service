package com.ecole221.classe.service.mapper;

import com.ecole221.classe.service.dto.ClasseDTO;
import com.ecole221.classe.service.dto.FiliereDTO;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.model.Filiere;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    public ClasseDTO my_classeEntityToClasseDTO(Classe classe){
        return modelMapper.map(classe, ClasseDTO.class);
    }

    public ClasseDTO classeEntityToClasseDTO(Classe c){
        return ClasseDTO.builder()
                .idDTO(c.getId())
                .libelleDTO(c.getLibelle())
                .fraisInscriptionDTO(c.getFraisInscription())
                .mensualiteDTO(c.getMensualite())
                .autreFraisDTO(c.getAutreFrais())
                .filiereDTO(filiereEntityToFiliereDTO(c.getFiliere()))
                .build();
    }

    public Classe classeDTOToClasseEntity(ClasseDTO classeDTO){
        return Classe.builder()
                .id(classeDTO.getIdDTO())
                .libelle(classeDTO.getLibelleDTO())
                .fraisInscription(classeDTO.getFraisInscriptionDTO())
                .mensualite(classeDTO.getMensualiteDTO())
                .autreFrais(classeDTO.getAutreFraisDTO())
                .filiere(filiereDTOToFiliereEntity(classeDTO.getFiliereDTO()))
                .build();
    }

    public FiliereDTO filiereEntityToFiliereDTO(Filiere filiere){
        return FiliereDTO.builder()
                .idDTO(filiere.getId())
                .libelleDTO(filiere.getLibelle())
                .build();
    }

    public Filiere filiereDTOToFiliereEntity(FiliereDTO filiereDTO){
        return Filiere.builder()
                .id(filiereDTO.getIdDTO())
                .libelle(filiereDTO.getLibelleDTO())
                .build();
    }
}
