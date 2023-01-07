package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.Ville;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findVilleByName(String name);
}
