package com.memoriesofwar.emergent.repositories;

import com.memoriesofwar.emergent.entities.Battalion;
import com.memoriesofwar.emergent.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattalionRepository extends CrudRepository<Battalion, Long> {

    List<Battalion> findByPlayer(Player player);
}
