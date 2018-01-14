package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.units.BasicUnit;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class BasicBattleEngine {
    public void resolve(List<BasicUnit> attackers, List<BasicUnit> defenders) {
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

    private void resolveBelligerent(List<BasicUnit> attackers, List<BasicUnit> defenders) {
        Random random = new Random();

        if (defenders.size() == 0)
            return;

        for (BasicUnit attacker : attackers) {
            BasicUnit target;
            do {
                target = defenders.get(random.nextInt(defenders.size()));

                int damage = attacker.getAttack() - target.getDefense();

                if (damage <= 0)
                    target.setDefense(0);

                long newHp = target.getHp() - Integer.toUnsignedLong(damage);
                target.setHp((int) newHp);
            } while (attacker.isRapidFireTriggered(target.getName()));
        }
    }

    private void removeDeadUnits(List<BasicUnit> units) {
        for(Iterator<BasicUnit> iterator = units.iterator(); iterator.hasNext();)
            if (iterator.next().getHp() <= 0)
                iterator.remove();
    }

    private void resetDefense(List<BasicUnit> units) {
        for (BasicUnit unit : units)
            unit.setDefense(unit.getMaxDefense());
    }
}
