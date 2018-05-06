package com.memoriesofwar.emergent.repositories;

import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {

    List<Unit> findByPlayer(Player player);
}
