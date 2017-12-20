package com.memoriesofwar.emergent.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.PathParam;

import com.memoriesofwar.emergent.Overworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.Territory;

@RestController
@RequestMapping(value = "/territories")
public class TerritoryResource {

    private Overworld overworld;

    @Autowired
    public TerritoryResource(Overworld overworld) {
        this.overworld = overworld;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Territory> territories() {

        return overworld.getTerritories();
    }

    @RequestMapping(value = "/{name}/links", method = RequestMethod.GET)
    public List<String> linksOfTerritory(@PathVariable("name") String name) {

        System.out.println(name);

        Territory territory = overworld.getTerritoryRepository().findByName(name);

        if(territory == null) {
            System.out.println("No territory found.");
            return null;
        }

        return territory.getLinks().stream().map(Territory::getName).collect(Collectors.toList());
    }
}
