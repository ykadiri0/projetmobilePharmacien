package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.Gard;
import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.beans.PharmacieGard;
import com.pharmacie.projetfinal.repositories.GardRepository;
import com.pharmacie.projetfinal.repositories.PharmacieGardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PGService {
    @Autowired
    PharmacieGardRepository pharmacieGardRepository;

    public List<PharmacieGard> getAllFactureWE(int id){
        return pharmacieGardRepository.findPharmacieGardsByPharmacie(new Pharmacie(id));
    }
    public void SaveFactureWE(PharmacieGard pharmacieGard){
        pharmacieGardRepository.save(pharmacieGard);
    }
    public void DeleteFactureWE(Integer id){
        pharmacieGardRepository.deleteById(id);
    }
    public PharmacieGard updateFactureWE(PharmacieGard pharmacieGard){
        return  pharmacieGardRepository.save(pharmacieGard);
    }
    public List<PharmacieGard> getAllByGard(Gard garde){
        return pharmacieGardRepository.findPharmacieGardByGard(garde);
}
    public List<PharmacieGard> getAllFactureWE(){
        return pharmacieGardRepository.findAll();
}
}
