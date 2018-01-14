package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Volunteers extends Unit {
    public Volunteers(Player player) {
        super("Volunteers", 25, 0, 250, player,null, null);
    }
}
