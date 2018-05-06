package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

import java.util.HashMap;

public class LightTank {
    public static Unit instantiateFor(Player player) {
        HashMap<String, Integer> lightTankRapidFire = new HashMap<>();
        lightTankRapidFire.put("Recruits", 6);
        return new Unit("Light Tank", 400, 50, 2700, player,lightTankRapidFire, null);
    }
}
