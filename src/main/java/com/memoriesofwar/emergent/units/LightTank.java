package com.memoriesofwar.emergent.units;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;

public class LightTank extends Unit {
    public LightTank(Player player) {
        super("Light Tank", 400, 50, 2700, player,null, null);
        rapidFire.put("Recruits", 6);
    }
}
