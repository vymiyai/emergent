package com.memoriesofwar.emergent.entities;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    private Long id;

    @ManyToOne
    private Faction faction;

    public Player(){}

    public Player(Long id, Faction faction){
        this.id = id;
        this.faction = faction;
    }

    public Faction getFaction() {
        return faction;
    }
}