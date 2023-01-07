package com.pharmacie.projetfinal.Controller;

import com.pharmacie.projetfinal.beans.User;
import com.pharmacie.projetfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/saveimage")
    public ResponseEntity<User> saveimage(@RequestParam("id") int id,@RequestParam("image") MultipartFile file){
        //userService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( null, HttpStatus.CREATED);
    }


    @GetMapping("/getallusers")
    public List<User> getall(){
        List countrys =userService.getAllFactureWE();
        return userService.getAllFactureWE();
    }
    @GetMapping("/getuser")
    public User user(@RequestParam(value = "id") int id){
        User countrys =userService.getUser(id);
        return countrys;
    }
    @GetMapping("/login")
    public User getall(@RequestParam(value = "email") String email,@RequestParam(value = "psw") String psw){
        User countrys =userService.UserAuth(email,psw);
        System.out.println(countrys);
        if(countrys!=null){
            return countrys;
        }
        else{
            return new User(-1);
        }
    }
    @PostMapping("/saveuser")
    public ResponseEntity<User> saveCountry(@RequestBody User factureWE){
        userService.SaveFactureWE(factureWE);
        return new ResponseEntity<>( factureWE, HttpStatus.CREATED);
    }
    @PutMapping("/updateuser")
    public ResponseEntity<User> updateEmployee(@RequestBody User factureWE) {
        User updateEmployee = userService.updateFactureWE(factureWE);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @PutMapping("/updateuserph")
    public ResponseEntity<User> updateUserPH(@RequestBody User factureWE) {
        User updateEmployee = userService.updateUP(factureWE);
        return new ResponseEntity<>(factureWE, HttpStatus.OK);
    }
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        userService.DeleteFactureWE(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
