package com.memoriesofwar.emergent.territories;

import com.memoriesofwar.emergent.factions.Faction;

import java.util.List;

public class Territory {

    private String name;

    private Faction originalFaction;

    private Faction faction;

    private List<String> links;

    private boolean isPort;

    public Territory(String name, Faction originalFaction, List<String> links, boolean isPort) {
        this.name = name;
        this.originalFaction = originalFaction;
        this.faction = originalFaction;
        this.links = links;
        this.isPort = isPort;
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

    public List<String> getLinks() { return links; }

    public boolean isPort() { return isPort; }

    @Override
    public String toString() {
        return this.name;
    }
}
