package com.pharmacie.projetfinal.services;

import com.pharmacie.projetfinal.beans.User;
import com.pharmacie.projetfinal.repositories.UserRepository;
import jakarta.persistence.CascadeType;
import org.hibernate.engine.internal.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> getAllFactureWE(){
        return userRepository.findAll();
    }
    public User getUser(int id){
        return userRepository.findById(id).get();
    }

    public User UserAuth(String email,String psw){
        return userRepository.findUserByEmailAndPsw(email,psw);
    }
    public void SaveFactureWE(User user){
        userRepository.save(user);
    }
    public void DeleteFactureWE(Integer id){
        userRepository.deleteById(id);
    }
    public User updateFactureWE(User user){
        return  userRepository.save(user);
    }
    public User updateUP(User user){
           User user1= userRepository.findById(user.getId()).get();
           user1.setPharmacie(user.getPharmacie());
           userRepository.save(user1);
          return user1;
    }

}
