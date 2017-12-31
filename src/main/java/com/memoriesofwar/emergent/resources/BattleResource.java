package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Battle;
import com.memoriesofwar.emergent.database.Faction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/battles")
public class BattleResource {

    private Overworld overworld;

    @Autowired
    public BattleResource(Overworld overworld) {
        this.overworld = overworld;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Battle> getBattles() {

        return (List<Battle>) overworld.getBattleRepository().findAll();
    }

    @RequestMapping(value = "/{factionName}", method = RequestMethod.GET)
    public List<Battle> getFactionBattles(@PathVariable("factionName") String factionName) {

        Faction faction = overworld.getFactionRepository().findByName(factionName);

        if (faction == null)
            return null;

        return overworld.getBattleRepository().findByAttackerOrDefender(faction, faction);
    }
}