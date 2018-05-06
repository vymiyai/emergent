package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Volunteers {
    public static Unit instantiateFor(Player player) {
        return new Unit("Volunteers", 25, 0, 250, player,null, null);
    }
}
