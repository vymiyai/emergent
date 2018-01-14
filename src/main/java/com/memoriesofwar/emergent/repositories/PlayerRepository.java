package com.memoriesofwar.emergent.repositories;

import com.memoriesofwar.emergent.entities.Faction;
import com.memoriesofwar.emergent.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByFaction(Faction faction);
}
