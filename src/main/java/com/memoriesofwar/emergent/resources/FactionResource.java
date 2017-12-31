package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.Territory;
import com.memoriesofwar.emergent.database.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

        return (List<Faction>) overworld.getFactionRepository().findAll();
    }

    @RequestMapping(value = "/{factionName}", method = RequestMethod.GET)
    public Faction getFaction(@PathVariable("factionName") String factionName) {

        return overworld.getFactionRepository().findByName(factionName);
    }

    @RequestMapping(value = "/{factionName}/territories", method = RequestMethod.GET)
    public List<Territory> getFactionTerritories(@PathVariable("factionName") String factionName) {

        Faction faction = overworld.getFactionRepository().findByName(factionName);

        if(faction == null)
            return null;

        return overworld.getTerritoryRepository().findByFaction(faction);
    }

    @RequestMapping(value = "/{factionName}/territories/neighbors", method = RequestMethod.GET)
    public List<Territory> getNeighboringFactionTerritories(@PathVariable("factionName") String factionName) {

        Faction faction = overworld.getFactionRepository().findByName(factionName);

        if(faction == null)
            return null;

        return getNeighboringFactionTerritories(overworld.getTerritoryRepository(), faction);
    }

    @RequestMapping(value = "/{factionName}/territories/number", method = RequestMethod.GET)
    public Integer getNumberOfFactionTerritories(@PathVariable("factionName") String factionName) {

        Faction faction = overworld.getFactionRepository().findByName(factionName);

        if(faction == null)
            return null;

        return overworld.getTerritoryRepository().countByFaction(faction);
    }

    public static List<Territory> getNeighboringFactionTerritories(TerritoryRepository territoryRepository, Faction faction) {

        List<Territory> factionTerritories = territoryRepository.findByFaction(faction);

        final HashSet<Territory> neighboringTerritorySet = new HashSet<>();
        final HashSet<Territory> factionTerritoriesSet = new HashSet<>();

        for(Territory territory : factionTerritories) {
            neighboringTerritorySet.addAll(territory.getLinks());
            factionTerritoriesSet.add(territory);
        }

        neighboringTerritorySet.removeAll(factionTerritories);

        return new ArrayList<>(neighboringTerritorySet);
    }
}
