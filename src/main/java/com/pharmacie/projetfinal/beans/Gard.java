package com.pharmacie.projetfinal.beans;

import jakarta.persistence.*;

@Entity
public class Gard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String type;
    public Gard() {

    }
    public Gard(int id) {
        this.id=id;
}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
