package com.ecole221.classe.service.helper;

import com.ecole221.classe.service.dto.ClasseDTO;
import com.ecole221.classe.service.exception.ClasseServiceException;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.service.IClasse;
import org.springframework.stereotype.Component;

@Component
public class ClasseHelper {
    private final IClasse classeService;

    public ClasseHelper(IClasse classeService) {
        this.classeService = classeService;
    }

    public void checkDataClasse(ClasseDTO classeDTO){
        if(classeService.findByClasse(classeDTO.getLibelleDTO()) != null){
            throw new ClasseServiceException("La classe ["+classeDTO.getLibelleDTO()+"] exixte déjà!");
        }
        /*
        if(classeDTO.getMensualiteDTO() <= 0){
            throw new ClasseServiceException("La mensualité doit être positif!");
        }
        if(classeDTO.getFraisInscriptionDTO() <= 0){
            throw new ClasseServiceException("Les frais d'inscription doivent être positif!");
        }
        if(classeDTO.getAutreFraisDTO() <= 0){
            throw new ClasseServiceException("Les autres frais doivent être positif!");
        }

         */
    }
}
