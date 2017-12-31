package com.memoriesofwar.emergent.resources;

import com.memoriesofwar.emergent.Overworld;
import com.memoriesofwar.emergent.database.Battle;
import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.Territory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/overworld")
public class OverworldResource {

    private Overworld overworld;

    private final int MAX_DAMAGE = 5;

    private final int MAX_NUMBER_OF_ATTACKING_BATTLES = 3;

    @Autowired
    public OverworldResource(Overworld overworld) {
        this.overworld = overworld;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public void resolve() {

        this.updateCooldown();
        this.resolveBattles();
        this.openBattles();
    }

    private void updateCooldown() {
        List<Territory> territories = overworld.getTerritoryRepository().findByCooldownGreaterThan(0);

        for(Territory territory : territories)
            territory.setCooldown(territory.getCooldown() - 1);
    }

    private void resolveBattles() {
        List<Battle> battles = (List<Battle>) overworld.getBattleRepository().findAll();

        Random random = new Random();

        for(Battle battle : battles) {
            int attackerBp = battle.getAttackerBp() - (random.nextInt(MAX_DAMAGE) + 1);
            int defenderBp = battle.getDefenderBp() - (random.nextInt(MAX_DAMAGE) + 1);

            // if both become 0 or negative at the same time, the defender wins.
            if(attackerBp <= 0) {
                battle.getTerritory().setCooldown(Territory.MAX_COOLDOWN);
                battle.getTerritory().setInBattle(false);
                overworld.getBattleRepository().delete(battle);
                continue;
            }

            if(defenderBp <= 0) {
                battle.getTerritory().setCooldown(Territory.MAX_COOLDOWN);
                battle.getTerritory().setFaction(battle.getAttacker());
                battle.getTerritory().setInBattle(false);
                overworld.getBattleRepository().delete(battle);
                continue;
            }

            battle.setAttackerBp(attackerBp);
            battle.setDefenderBp(defenderBp);
        }
    }

    private void openBattles() {
        List<Faction> factions = (List<Faction>) overworld.getFactionRepository().findAll();
        Collections.shuffle(factions);

        for(Faction faction : factions) {
            int numberOfOpenBattles = overworld.getBattleRepository().countByAttacker(faction);
            if(numberOfOpenBattles < MAX_NUMBER_OF_ATTACKING_BATTLES) {
                int numberOfRolls = MAX_NUMBER_OF_ATTACKING_BATTLES - numberOfOpenBattles;
                List<Territory> territories = getNeighboringFactionTerritories(faction);
                final int[] ints = new Random().ints(0, territories.size()).distinct().limit(numberOfRolls).toArray();

                for(int i : ints) {
                    Territory territory = territories.get(i);
                    Battle battle = new Battle(territories.get(i), faction, territory.getFaction());
                    overworld.getBattleRepository().save(battle);

                    territory.setInBattle(true);
                }
            }
        }
    }

    private List<Territory> getNeighboringFactionTerritories(Faction faction) {
        return FactionResource.getNeighboringFactionTerritories(overworld.getTerritoryRepository(), faction)
                .stream().filter(territory -> !territory.isOnCooldown() && !territory.isInBattle())
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public List<HashMap<String, Object>> getOverview() {

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        List<Faction> factions = (List<Faction>) overworld.getFactionRepository().findAll();

        for(Faction faction : factions) {
            HashMap<String, Object> stats = new HashMap<>();
            stats.put("name", faction.getName());
            stats.put("numberOfTerritories", overworld.getTerritoryRepository().countByFaction(faction).toString());

            result.add(stats);
        }

        List<Battle> battles = (List<Battle>) overworld.getBattleRepository().findAll();

        for(Battle battle : battles) {
            HashMap<String, Object> battleStats = new HashMap<>();
            battleStats.put("Battle for " + battle.getTerritory().getName(), battle.toString());

            result.add(battleStats);
        }

        return result;
    }
}
