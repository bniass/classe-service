package com.ecole221.classe.service.service;

import com.ecole221.classe.service.model.Classe;
import com.ecole221.classe.service.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService implements IClasse{

    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    @Override
    public Classe save(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public Classe findByClasse(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }

    @Override
    public Classe findById(long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Classe classe) {
        classeRepository.delete(classe);
    }
}
