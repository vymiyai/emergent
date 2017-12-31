package com.memoriesofwar.emergent.database;

import javax.persistence.*;

@Entity
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Territory territory;

    @ManyToOne
    private Faction attacker;

    @ManyToOne
    private Faction defender;

    private Integer attackerBp;

    private Integer defenderBp;

    public Battle() {}

    public Battle(Territory territory, Faction attacker, Faction defender) {
        this.territory = territory;
        this.attacker = attacker;
        this.defender = defender;
        this.attackerBp = 100;
        this.defenderBp = 100;
    }

    public Long getId() {
        return id;
    }

    public Territory getTerritory() {
        return territory;
    }

    public Faction getAttacker() {
        return attacker;
    }

    public Faction getDefender() {
        return defender;
    }

    public int getAttackerBp() {
        return attackerBp;
    }

    public void setAttackerBp(int attackerBp) {
        this.attackerBp = attackerBp;
    }

    public int getDefenderBp() {
        return defenderBp;
    }

    public void setDefenderBp(int defenderBp) {
        this.defenderBp = defenderBp;
    }

    @Override
    public String toString() {
        return "(ATK) " + attacker.getAcronym() + " " + attackerBp + " x " + defenderBp + " " + defender.getAcronym() + " (DEF)";
    }
}