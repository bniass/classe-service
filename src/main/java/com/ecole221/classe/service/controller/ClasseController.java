package com.ecole221.classe.service.controller;

import com.ecole221.classe.service.dto.ClasseDTO;
import com.ecole221.classe.service.exception.ClasseServiceException;
import com.ecole221.classe.service.exception.ClasseServiceNotFoundException;
import com.ecole221.classe.service.helper.ClasseHelper;
import com.ecole221.classe.service.mapper.Mapper;
import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import com.ecole221.classe.service.service.IClasse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/classes")
public class ClasseController {

    //@Autowired
    //private ClasseRepository classeRepository;

    private final Mapper mapper;
    private final ClasseHelper classeHelper;
    private final IClasse classeService;

    public ClasseController(ClasseRepository classeRepository, Mapper mapper, ClasseHelper classeHelper,
                            IClasse classeService) {
        this.classeService = classeService;
        this.mapper = mapper;
        this.classeHelper = classeHelper;
    }

    @GetMapping
    public @ResponseBody List<ClasseDTO> index(){
        return classeService.findAll().stream().map(c-> mapper.classeEntityToClasseDTO(c)).toList();
    }

    @PostMapping
    public @ResponseBody ClasseDTO save(@Valid @RequestBody ClasseDTO classeDTO){
        try {
             classeHelper.checkDataClasse(classeDTO);
             return mapper.classeEntityToClasseDTO(classeService.save(mapper.classeDTOToClasseEntity(classeDTO)));
        } catch (ClasseServiceException e) {
            throw new ClasseServiceException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ClasseDTO findById(@PathVariable long id){
        Classe classe = classeService.findById(id);
        if(classe == null){
            throw new ClasseServiceNotFoundException("La classe avec l'id "+id+" n'existe pas!");
        }
        return mapper.classeEntityToClasseDTO(classe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable long id){
        Classe classe = classeService.findById(id);
        if(classe == null){
            throw new ClasseServiceNotFoundException("La classe avec l'id "+id+" n'existe pas!");
        }
        classeService.remove(classe);
        return  ResponseEntity.ok("Deleted!");
    }

    @PutMapping
    public @ResponseBody ClasseDTO update(@RequestBody ClasseDTO classeDTO){
        Classe classe = classeService.findById(classeDTO.getIdDTO());
        if(classe == null){
            throw new ClasseServiceNotFoundException("La classe avec l'id "+classeDTO.getIdDTO()+" n'existe pas!");
        }
        return mapper.classeEntityToClasseDTO(classeService.save(mapper.classeDTOToClasseEntity(classeDTO)));
    }
}
