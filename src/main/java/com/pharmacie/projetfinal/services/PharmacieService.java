package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.beans.Zone;
import com.pharmacie.projetfinal.repositories.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PharmacieService {
    @Autowired
    PharmacieRepository pharmacieRepository;

    public List<Pharmacie> getAllFactureWE(){
        return pharmacieRepository.findAll();
    }
    public Pharmacie SaveFactureWE(Pharmacie pharmacie){
        return  pharmacieRepository.save(pharmacie);
    }
    public void DeleteFactureWE(Integer id){
        pharmacieRepository.deleteById(id);
    }
    public Pharmacie updateFactureWE(Pharmacie pharmacie){
        return  pharmacieRepository.save(pharmacie);
    }
    public List<Pharmacie> getAllByZone(Zone zone){
        return (List<Pharmacie>) pharmacieRepository.findPharmacieByZone(zone);
}
}
