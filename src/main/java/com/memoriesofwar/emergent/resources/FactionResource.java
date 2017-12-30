package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.Territory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/factions")
public class FactionResource {

    private Overworld overworld;

    @Autowired
    public FactionResource(Overworld overworld) {
        this.overworld = overworld;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Faction> getFactions() {

        return overworld.getFactions();
    }

    @RequestMapping(value = "/{factionName}", method = RequestMethod.GET)
    public List<Faction> getFaction() {

        return overworld.getFactions();
    }

    @RequestMapping(value = "/{factionName}/territories", method = RequestMethod.GET)
    public List<Territory> getFactionTerritories(@PathVariable("factionName") String factionName) {

        Faction faction = overworld.getFactionRepository().findByName(factionName);

        if(faction == null)
            return null;

        return overworld.getTerritoryRepository().findAllByFaction(faction);
    }

    @RequestMapping(value = "/{factionName}/territories/neighbors", method = RequestMethod.GET)
    public List<HashMap> getNeighboringFactionTerritories(@PathVariable("factionName") String factionName) {

        List<Territory> factionTerritories = this.getFactionTerritories(factionName);

        final HashSet<Territory> neighboringTerritorySet = new HashSet<>();
        final HashSet<Territory> factionTerritoriesSet = new HashSet<>();

        for(Territory territory : factionTerritories) {
            neighboringTerritorySet.addAll(territory.getLinks());
            factionTerritoriesSet.add(territory);
        }

        neighboringTerritorySet.removeAll(factionTerritories);

        return neighboringTerritorySet.stream()
                .map((n) -> {
                    HashMap<String, String> neighbor = new HashMap<String, String>();
                    neighbor.put("name", n.getName());
                    neighbor.put("isPort", String.valueOf(n.isPort()));
                    return neighbor;
                })
                .collect(Collectors.toList());
    }
}
