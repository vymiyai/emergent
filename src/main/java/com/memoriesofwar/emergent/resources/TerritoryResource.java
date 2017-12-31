package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Territory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/territories")
public class TerritoryResource {

    private Overworld overworld;

    @Autowired
    public TerritoryResource(Overworld overworld) {
        this.overworld = overworld;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Territory> getTerritories() {

        return (List<Territory>) overworld.getTerritoryRepository().findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Territory getTerritory(@PathVariable("name") String name) {

        Territory territory = overworld.getTerritoryRepository().findByName(name);

        if(territory == null)
            return null;

        return territory;
    }
}
