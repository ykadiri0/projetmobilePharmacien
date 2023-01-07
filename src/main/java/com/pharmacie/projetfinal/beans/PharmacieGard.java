package com.pharmacie.projetfinal.beans;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class PharmacieGard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Date date_debut;
    private Date date_fin;
    @ManyToMany
    private List<Pharmacie> pharmacie;
    @ManyToMany
    private List<Gard> gard;

    public List<Pharmacie> getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(List<Pharmacie> pharmacie) {
        this.pharmacie = pharmacie;
    }

    public List<Gard> getGard() {
        return gard;
    }

    public void setGard(List<Gard> gard) {
        this.gard = gard;
    }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
