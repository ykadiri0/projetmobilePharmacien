package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.Ville;
import com.pharmacie.projetfinal.beans.Zone;
import com.pharmacie.projetfinal.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@RestController
public class ZoneController {
    @Autowired
    ZoneService zoneService;
    @GetMapping("/getallzone")
    public List<Zone> getall(){
        List countrys =zoneService.getAllFactureWE();
        return zoneService.getAllFactureWE();
    }
    @GetMapping("/getallzonebyville")
    public List<Zone> getallbyville(@RequestParam("id") int id){
        List countrys =zoneService.getAllZONEBYVILLE(id);
        return countrys;
    }
    @GetMapping("/getallzonebyvillen")
    public List<Zone> getallbyvillen(@RequestParam("name") String name){
        List countrys =zoneService.getAllZONEBYVILLE(name);
        return countrys;
    }

    @PostMapping("/savezone")
    public ResponseEntity<Zone> saveCountry(@RequestBody Zone factureWE){
        zoneService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( factureWE, HttpStatus.CREATED);
    }
    @PutMapping("/updatezone")
    public ResponseEntity<Zone> updateEmployee(@RequestBody Zone factureWE) {
        Zone updateEmployee = zoneService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/deletezone/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        zoneService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getallzonebyname")
    public List<Zone> getzonebyname(@RequestParam("name") String name){
        List countrys =zoneService.getZoneByName(name);
        return countrys;
}
}
