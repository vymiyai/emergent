package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.entities.Unit;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class BasicBattleEngine {
    public void resolve(List<Unit> attackers, List<Unit> defenders) {
        // do damage calculations.
        resolveBelligerent(attackers, defenders);
        resolveBelligerent(defenders, attackers);

        // remove units with hp 0.
        removeDeadUnits(attackers);
        removeDeadUnits(defenders);

        // reset integrity.
        resetDefense(attackers);
        resetDefense(defenders);
    }

    private void resolveBelligerent(List<Unit> attackers, List<Unit> defenders) {
        Random random = new Random();

        if (defenders.size() == 0)
            return;

        for (Unit attacker : attackers) {
            Unit target;
            do {
                target = defenders.get(random.nextInt(defenders.size()));

                Float absoluteDamage = attacker.getAttack() * attacker.getDamageMultiplierByTargetName(target.getName());
                int damage = absoluteDamage.intValue() - target.getDefense();

                if (damage <= 0)
                    target.setDefense(0);

                long newHp = target.getHp() - Integer.toUnsignedLong(damage);
                target.setHp((int) newHp);
            } while (attacker.isRapidFireTriggered(target.getName()));
        }
    }

    private void removeDeadUnits(List<Unit> units) {
        for(Iterator<Unit> iterator = units.iterator(); iterator.hasNext();)
            if (iterator.next().getHp() <= 0)
                iterator.remove();
    }

    private void resetDefense(List<Unit> units) {
        for (Unit unit : units)
            unit.setDefense(unit.getMaxDefense());
    }
}
