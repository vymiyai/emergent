package com.memoriesofwar.emergent.entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int attack;
    private int defense;
    private int maxDefense;
    private int hp;
    private int maxHp;

    @ManyToOne
    private Player player;

    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    @CollectionTable(name="rapid_fire", joinColumns=@JoinColumn(name="rapid_fire_id"))
    protected Map<String, Integer> rapidFire;

    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    @CollectionTable(name="damage_multipliers", joinColumns=@JoinColumn(name="damage_multiplier_id"))
    protected Map<String, Float> damageMultipliers;

    public Unit(){}

    public Unit(String name, int attack, int defense, int maxHp, Player player, Map<String, Integer> rapidFire, Map<String, Float> damageMultipliers) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxDefense = defense;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.player = player;
        this.rapidFire = Optional.ofNullable(rapidFire).orElse(new HashMap<>());
        this.damageMultipliers = Optional.ofNullable(damageMultipliers).orElse(new HashMap<>());
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

    public Map<String, Integer> getRapidFire() {
        return rapidFire;
    }

    public Map<String, Float> getDamageMultipliers() { return damageMultipliers; }

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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

    public Float getDamageMultiplierByTargetName(String name) {
        if(damageMultipliers.containsKey(name))
            return damageMultipliers.get(name);
        else
            return 1f;
    }

    @Override
    public String toString() {
        return String.format("%s: [HP %d/%d | ATK %d | DEF %d]", name, hp, maxHp, attack, defense);
    }
}
