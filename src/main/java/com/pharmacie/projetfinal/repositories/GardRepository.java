package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.Gard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardRepository extends JpaRepository<Gard,Integer> {
}
