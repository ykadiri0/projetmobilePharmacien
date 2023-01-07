package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.Gard;
import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.beans.PharmacieGard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PharmacieGardRepository extends JpaRepository<PharmacieGard,Integer> {
    List<PharmacieGard> findPharmacieGardsByPharmacie(Pharmacie pharmacie);

    List<PharmacieGard> findPharmacieGardByGard(Gard gard);
    @Query("select a from PharmacieGard a where a.date_fin >= :creationDateTime")
    List<PharmacieGard> findAllWithCreationDateTimeBefore(@Param("creationDateTime") Date creationDateTime);
}
