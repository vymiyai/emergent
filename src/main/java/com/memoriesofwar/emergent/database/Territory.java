package com.memoriesofwar.emergent.database;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Territory {

    @Transient
    public static final int MAX_COOLDOWN = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Faction originalFaction;

    @ManyToOne
    private Faction faction;

    @JsonSerialize(using = TerritorySerializer.class)
    @ManyToMany
    private List<Territory> links;

    private boolean isPort;

    private boolean isCapital;

    private boolean isInBattle;

    private int cooldown;

    public Territory() {}

    public Territory(String name, Faction originalFaction, boolean isPort, boolean isCapital) {
        this.name = name;
        this.originalFaction = originalFaction;
        this.faction = originalFaction;
        this.isPort = isPort;
        this.isCapital = isCapital;
        this.isInBattle = false;
        this.cooldown = 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Faction getOriginalFaction() {
        return originalFaction;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public List<Territory> getLinks() {
        return links;
    }

    public void setLinks(Territory... links) {
        this.links = Arrays.asList(links);
    }

    public boolean isPort() {
        return isPort;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public boolean isInBattle() {
        return isInBattle;
    }

    public void setInBattle(boolean inBattle) {
        isInBattle = inBattle;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isOnCooldown() {
        return cooldown > 0 ? true : false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private static class TerritorySerializer extends JsonSerializer<List<Territory>> {

        @Override
        public void serialize(
                List<Territory> territories,
                JsonGenerator generator,
                SerializerProvider provider) throws IOException {

            List<String> names = new ArrayList<>();
            for (Territory territory : territories) {
                names.add(territory.getName());
            }
            generator.writeObject(names);
        }
    }
}
