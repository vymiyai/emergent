package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.Territory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public List<Faction> factions() {

        return overworld.getFactions();
    }

    @RequestMapping(value = "/{name}/territories", method = RequestMethod.GET)
    public List<Territory> territoriesOfFaction(@PathVariable("name") String name) {

        System.out.println(name);

        Faction faction = overworld.getFactionRepository().findByName(name);

        if(faction == null) {
            System.out.println("No faction found.");
            return null;
        }

        return overworld.getTerritoryRepository().findAllByFaction(faction);
    }

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public List<String> getNamesOfFactions() {

        return ((List<Faction>) overworld.getFactionRepository().findAll()).stream().map(Faction::getName).collect(Collectors.toList());
    }
}
