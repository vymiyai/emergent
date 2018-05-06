package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Recruits {
    public static Unit instantiateFor(Player player) {
        return new Unit("Recruits", 50, 10, 400, player, null, null);
    }
}
