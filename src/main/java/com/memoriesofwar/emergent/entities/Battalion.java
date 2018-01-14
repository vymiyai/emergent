package com.memoriesofwar.emergent.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Battalion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Territory currentLocation;

    @OneToMany
    private List<Unit> units;

    public Battalion(){}

    public Battalion(Player player, List<Unit> units) {
        this.player = player;
        this.units = Optional.ofNullable(units).orElse(new ArrayList<>());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Battalion " + id + ":\n");
        for (Unit unit : units)
            result.append(unit.toString() + "\n");

        return result.toString();
    }
}