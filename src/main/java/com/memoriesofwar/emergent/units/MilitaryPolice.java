package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class MilitaryPolice {
    public static Unit instantiateFor(Player player) {
        return new Unit("Military Police", 100, 20, 600, player,null, null);
    }
}
