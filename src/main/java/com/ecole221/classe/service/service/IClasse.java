package com.ecole221.classe.service.service;

import com.ecole221.classe.service.model.Classe;

import java.util.List;

public interface IClasse {

    public List<Classe> findAll();

    public Classe save(Classe classe);

    public Classe findByClasse(String libelle);

    public Classe findById(long id);

    public void remove(Classe classe);
}
