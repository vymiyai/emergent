package com.memoriesofwar.emergent.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerritoryRepository extends CrudRepository<Territory, Long> {

    Territory findByName(String name);

    List<Territory> findAllByFaction(Faction faction);
}