package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.Ville;
import com.pharmacie.projetfinal.beans.Zone;
import com.pharmacie.projetfinal.repositories.VilleRepository;
import com.pharmacie.projetfinal.repositories.ZoneReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZoneService {
    @Autowired
    ZoneReposytory zoneReposytory;
    @Autowired
    VilleService villeService;
    public List<Zone> getAllZONEBYVILLE(int id){
        Ville ville=new Ville();
        ville.setId(id);
        return zoneReposytory.findAllByVille(ville);}
    public List<Zone> getAllZONEBYVILLE(String id){

        return zoneReposytory.findAllByVille(villeService.getVilleByName(id));}
    public List<Zone> getAllFactureWE(){
        return zoneReposytory.findAll();
    }
    public void SaveFactureWE(Zone zone){
        zoneReposytory.save(zone);
    }
    public void DeleteFactureWE(Integer id){
        zoneReposytory.deleteById(id);
    }
    public Zone updateFactureWE(Zone zone){
        return  zoneReposytory.save(zone);
    }


    public List<Zone> getAllByVille(Integer id){
        Ville ville=new Ville();
        ville.setId(id);
        return zoneReposytory.findAllByVille(ville);
    }
    public List<Zone> getZoneByName(String name){

        return zoneReposytory.findZoneByName(name);
}
}
