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

    public Faction() {}

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() { return id; }
}
