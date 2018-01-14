package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class Recruits extends Unit {
    public Recruits(Player player) {
        super("Recruits", 50, 10, 400, player, null, null);
    }
}
