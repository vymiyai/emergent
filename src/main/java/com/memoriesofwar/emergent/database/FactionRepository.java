package com.memoriesofwar.emergent.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRepository extends CrudRepository<Faction, Long> {

    Faction findByName(String name);
}
