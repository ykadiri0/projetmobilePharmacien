package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.Ville;
import com.pharmacie.projetfinal.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class VilleController {
    @Autowired
    VilleService villeService;
    @GetMapping("/getallville")
    public List<Ville> getall(){
        List countrys =villeService.getAllFactureWE();
        return villeService.getAllFactureWE();
    }
    @GetMapping("/getvillebyname")
    public Ville getvillebyname(@RequestParam(value = "name") String name){
        Ville ville =villeService.getVilleByName(name);
        return ville;
    }

    @PostMapping("/save")
    public ResponseEntity<Ville> saveCountry(@RequestBody Ville factureWE){
        villeService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( factureWE, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Ville> updateEmployee(@RequestBody Ville factureWE) {
        Ville updateEmployee = villeService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        villeService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getallville/{id}")
    public Ville getbyId(@PathVariable("id") Integer id){
        Ville country =villeService.getVilleById(id);
        return country;
    }

}
