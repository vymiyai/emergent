package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

import java.util.HashMap;

public class ATRifles {
    public static Unit instantiateFor(Player player) {
        HashMap<String, Integer> atRiflesRapidFire = new HashMap<>();
        atRiflesRapidFire.put("Light Tank", 2);

        HashMap<String, Float> atRiflesDamageMultipliers = new HashMap<>();
        atRiflesDamageMultipliers.put("Light Tank", 5f);

        return new Unit("AT Rifles", 40, 10, 400, player, atRiflesRapidFire, atRiflesDamageMultipliers);
    }
}
