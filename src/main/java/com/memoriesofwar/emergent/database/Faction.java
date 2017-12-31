package com.memoriesofwar.emergent.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String acronym;

    public Faction() {}

    public Faction(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getAcronym() { return acronym; }
}
