package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.Ville;
import com.pharmacie.projetfinal.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VilleService {
    @Autowired
    VilleRepository villerepository;

    public List<Ville> getAllFactureWE(){
        return villerepository.findAll();
    }
    public Ville getVilleByName(String name){
        return villerepository.findVilleByName(name);
    }
    public void SaveFactureWE(Ville factureWE){
        villerepository.save(factureWE);
    }
    public void DeleteFactureWE(Integer id){
        villerepository.deleteById(id);
    }
    public Ville updateFactureWE(Ville factureWE){
        return  villerepository.save(factureWE);
    }
    public Ville getVilleById(int id){
        return villerepository.findById(id).get();
}

}

