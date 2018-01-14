package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class MilitaryPolice extends Unit {
    public MilitaryPolice(Player player) {
        super("Military Police", 100, 20, 600, player,null, null);
    }
}
