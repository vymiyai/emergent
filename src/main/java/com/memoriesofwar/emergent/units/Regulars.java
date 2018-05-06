package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Regulars {
    public static Unit instantiateFor(Player player) {
        return new Unit("Regulars", 150, 25, 1000, player,null, null);
    }
}