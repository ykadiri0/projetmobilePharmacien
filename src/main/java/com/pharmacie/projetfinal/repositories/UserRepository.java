package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepositoryImplementation<User,Integer> {
    User findUserByEmailAndPsw(String email,String psw);
}
