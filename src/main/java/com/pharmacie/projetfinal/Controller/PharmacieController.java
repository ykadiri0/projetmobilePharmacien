package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.beans.Zone;
import com.pharmacie.projetfinal.repositories.PharmacieRepository;
import com.pharmacie.projetfinal.repositories.ZoneReposytory;
import com.pharmacie.projetfinal.services.PharmacieService;
import com.pharmacie.projetfinal.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PharmacieController {
    @Autowired
    PharmacieService pharmacieService;

    @Autowired
    PharmacieRepository pharmacieRepository;

    @Autowired
    ZoneReposytory zoneReposytory;

    @GetMapping("/getallphar")
    public List<Pharmacie> getall(){
        List countrys =pharmacieService.getAllFactureWE();
        return pharmacieService.getAllFactureWE();
    }

    @PostMapping("/savephar")
    public ResponseEntity<Pharmacie> saveCountry(@RequestBody Pharmacie factureWE){

        return new ResponseEntity<>(  pharmacieService.SaveFactureWE(factureWE), HttpStatus.CREATED);
    }
    @PutMapping("/updatephar")
    public ResponseEntity<Pharmacie> updateEmployee(@RequestBody Pharmacie factureWE) {
        Pharmacie updateEmployee = pharmacieService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/deletephar/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        pharmacieService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




    @PutMapping("/etatp")
    public ResponseEntity<Pharmacie> etatp(@RequestBody Pharmacie factureWE) {
        factureWE.setEtat(1);
        Pharmacie updateEmployee = pharmacieService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @PutMapping("/etatn")
    public ResponseEntity<Pharmacie> etatn(@RequestBody Pharmacie factureWE) {
        factureWE.setEtat(2);
        Pharmacie updateEmployee = pharmacieService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @GetMapping("/getallstats")
    public List getallstats(){
        List countrys =pharmacieRepository.dashbord();
        return countrys;
    }
    @GetMapping("/getallstats2")
    public List getallstats2(){
        List countrys =pharmacieRepository.dashbord2();
        return countrys;
    }

    @GetMapping("/getgardnow")
    public List<Pharmacie> getgardnow(){
        List<Pharmacie> countrys =pharmacieRepository.phagardNow();
        List<Pharmacie> lists = new ArrayList<Pharmacie>();
        //for(Object p: countrys){
        //  lists.add(new Pharmacie(p[0], p.getName(), p.getLat(), p.getLon(),p.getEtat() ));
        //}
        return countrys;
}



    @GetMapping("/getbyzoneandville")
    public List<Pharmacie> getbyzoneandville(@RequestParam(value = "zone") String zone){
        List countrys =pharmacieRepository.findPharmacieByZone( zoneReposytory.findZoneByName(zone).get(0));
        return countrys;
}
}
