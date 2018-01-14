package com.memoriesofwar.emergent.repositories;

import com.memoriesofwar.emergent.entities.Battle;
import com.memoriesofwar.emergent.entities.Faction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BattleRepository extends CrudRepository<Battle, Long> {

    List<Battle> findByAttackerOrDefender(Faction attacker, Faction defender);

    Integer countByAttacker(Faction attacker);

    List<Battle> findByDefender(Faction defender);
}
