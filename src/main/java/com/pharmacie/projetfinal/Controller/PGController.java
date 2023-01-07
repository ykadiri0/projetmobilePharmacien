package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.Gard;
import com.pharmacie.projetfinal.beans.PharmacieGard;
import com.pharmacie.projetfinal.repositories.PharmacieGardRepository;
import com.pharmacie.projetfinal.services.GardService;
import com.pharmacie.projetfinal.services.PGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PGController {
    @Autowired
    PGService pgService;
    @Autowired
    PharmacieGardRepository pharmacieGardRepository;



    @GetMapping("/getallPG1")
    public List<PharmacieGard> getallPG(@RequestParam(value = "id") int id){
        List countrys =pgService.getAllFactureWE(id);
        return countrys;
    }

    @GetMapping("/getallPG")
    public List<PharmacieGard> getallPG(){
        List countrys =pgService.getAllFactureWE();
        return pgService.getAllFactureWE();
    }





    @PostMapping("/savePG")
    public ResponseEntity<PharmacieGard> savePG(@RequestBody PharmacieGard factureWE){
        System.out.println(factureWE.toString());
        pgService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( factureWE, HttpStatus.CREATED);
    }
    @PutMapping("/updatePG")
    public ResponseEntity<PharmacieGard> updatePG(@RequestBody PharmacieGard factureWE) {
        PharmacieGard updateEmployee = pgService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/deletePG/{id}")
    public ResponseEntity<?> deletePG(@PathVariable("id") Integer id) {
        pgService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getallpharmaciebygarde")
    public List<PharmacieGard> getallbyville(@RequestParam("id") int id){
        List countrys = (List) pgService.getAllByGard(new Gard(id));
        return countrys;
    }

    @GetMapping("/getty1")
    public List<PharmacieGard> getallP(@RequestParam(value = "id") int id){
        System.out.println(id);
        List<PharmacieGard>  countrys =pharmacieGardRepository.findAllWithCreationDateTimeBefore( new Date());
        List<PharmacieGard> p=new ArrayList<>();
        for(PharmacieGard o:countrys){
            if(o.getGard().get(0).getId()==id){
                p.add(o);
            }
        }
       return p;
}









    @GetMapping("/getty")
    public List<PharmacieGard> getallP(){
        List countrys =pharmacieGardRepository.findAllWithCreationDateTimeBefore(new Date());
        return countrys;
    }
    @GetMapping("/getallp")
    public List<PharmacieGard> getallbyid(@RequestParam(value = "id") int id){
        List countrys =pgService.getAllFactureWE(id);
        return countrys;
    }


}
