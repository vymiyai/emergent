package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.territories.Territory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/territories")
public class Controller {

    private Overworld overworld;

    @Autowired
    public Controller(Overworld overworld) {
        this.overworld = overworld;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Territory> root() {
        return overworld.getTerritories();
    }
}
