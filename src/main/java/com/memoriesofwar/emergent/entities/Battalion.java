package com.memoriesofwar.emergent.entities;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(orphanRemoval = true)
    private ArrayList<Unit> units;

    private boolean inReserve = true;

    public Battalion(){}

    public Battalion(Player player, ArrayList<Unit> units) {
        this.player = player;
        this.units = Optional.ofNullable(units).orElse(new ArrayList<>());
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public Territory getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Territory currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isInReserve() {
        return inReserve;
    }

    public void setInReserve(boolean inReserve) {
        this.inReserve = inReserve;
    }

    @Override
    public String toString() {
        final String location;
        if(currentLocation == null)
            location = "unknown location";
        else
            location = currentLocation.getName();

        StringBuilder result = new StringBuilder();
        result.append("Battalion " + id + " [stationed in " + location + "]:\n");

        for (Unit unit : units)
            result.append("  " + unit.toString() + "\n");

        return result.toString();
    }
}