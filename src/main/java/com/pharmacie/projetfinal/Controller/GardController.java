package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.Gard;
import com.pharmacie.projetfinal.beans.Zone;
import com.pharmacie.projetfinal.services.GardService;
import com.pharmacie.projetfinal.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GardController {
    @Autowired
    GardService gardService;
    @GetMapping("/getallgard")
    public List<Gard> getall(){
        List countrys =gardService.getAllFactureWE();
        return gardService.getAllFactureWE();
    }

    @PostMapping("/savegard")
    public ResponseEntity<Gard> saveCountry(@RequestBody Gard factureWE){
        gardService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( factureWE, HttpStatus.CREATED);
    }
    @PutMapping("/updategard")
    public ResponseEntity<Gard> updateEmployee(@RequestBody Gard factureWE) {
        Gard updateEmployee = gardService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/deletegard/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        gardService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
