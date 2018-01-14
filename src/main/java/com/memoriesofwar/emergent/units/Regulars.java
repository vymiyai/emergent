package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Regulars extends Unit {
    public Regulars(Player player) {
        super("Regulars", 150, 25, 1000, player,null, null);
    }
}