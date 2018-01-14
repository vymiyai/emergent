package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class ATRifles extends Unit {
    public ATRifles(Player player) {
        super("AT Rifles", 40, 10, 400, player, null, null);
        rapidFire.put("Light Tank", 2);
        damageMultipliers.put("Light Tank", 5f);
    }
}
