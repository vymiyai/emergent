package com.memoriesofwar.emergent.units;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class BasicUnit {

    private String name;
    private int attack;
    private int defense;
    private int maxDefense;
    private int hp;
    private int maxHp;
    protected Map<String, Integer> rapidFire;

    public BasicUnit(String name, int attack, int defense, int maxHp, Map<String, Integer> rapidFire) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxDefense = defense;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.rapidFire = Optional.ofNullable(rapidFire).orElse(new HashMap<>());
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Map<String, Integer> getRapidFire() {
        return rapidFire;
    }

    public boolean isRapidFireTriggered(String name) {
        if(!rapidFire.containsKey(name))
            return false;

        Random random = new Random();
        double rapidFireValue = rapidFire.get(name).doubleValue();
        double threshold = (rapidFireValue - 1)/rapidFireValue;
        if(random.nextGaussian() < threshold)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return String.format("%s: [HP %d/%d | ATK %d | DEF %d]", name, hp, maxHp, attack, defense);
    }
}
