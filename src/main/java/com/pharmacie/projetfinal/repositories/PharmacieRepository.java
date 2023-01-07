package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.Pharmacie;
import com.pharmacie.projetfinal.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie,Integer> {
    List<Pharmacie> findPharmacieByZone(Zone zone);

    @Query(
            value = "SELECT COUNT(a.id) ,e.name FROM pharmacie a, zone e where a.zone_id=e.id GROUP BY a.zone_id order by zone_id;",
            nativeQuery = true)
    List dashbord();

    @Query(
            value = "SELECT COUNT(a.id) ,q.name FROM pharmacie a, zone e, ville q where a.zone_id=e.id and q.id=e.ville_id GROUP BY e.name order by e.name;",
            nativeQuery = true)
    List dashbord2();


    @Query(
            value = "select  p from pharmacie p where id IN(select pharmacie_id from pharmacie_gard_pharmacie where pharmacie_gard_id IN(SELECT id FROM pharmacie_gard where date_debut<SYSDATE() and date_fin>SYSDATE()));",
            nativeQuery = true)
    List phagardNow();
}
