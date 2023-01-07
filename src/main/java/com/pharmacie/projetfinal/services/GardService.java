package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.Gard;
import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.repositories.GardRepository;
import com.pharmacie.projetfinal.repositories.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GardService {
    @Autowired
    GardRepository gardRepository;

    public List<Gard> getAllFactureWE(){
        return gardRepository.findAll();
    }
    public void SaveFactureWE(Gard gard){
        gardRepository.save(gard);
    }
    public void DeleteFactureWE(Integer id){
        gardRepository.deleteById(id);
    }
    public Gard updateFactureWE(Gard gard){
        return  gardRepository.save(gard);
    }
}
