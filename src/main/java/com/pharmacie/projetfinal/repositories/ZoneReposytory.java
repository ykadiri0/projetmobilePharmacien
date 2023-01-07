package com.pharmacie.projetfinal.repositories;

import com.pharmacie.projetfinal.beans.Ville;
import com.pharmacie.projetfinal.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneReposytory extends JpaRepository<Zone,Integer> {
    List<Zone> findAllByVille(Ville ville);

    List<Zone> findZoneByName(String name);
}
