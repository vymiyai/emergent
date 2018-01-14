package com.memoriesofwar.emergent.units;

public class ATRifles extends BasicUnit {
    public ATRifles() {
        super("AT Rifles", 200, 10, 600, null);
        rapidFire.put("Light Tank", 2);
    }
}
