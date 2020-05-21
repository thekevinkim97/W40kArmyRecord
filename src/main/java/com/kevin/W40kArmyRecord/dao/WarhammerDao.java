package com.kevin.W40kArmyRecord.dao;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.model.Unit;

import java.util.List;
import java.util.Optional;

public interface WarhammerDao {

    int insertFaction(Faction faction);
    int insertArmy(Army army);
    int insertUnit(Unit unit);

    List<Faction> selectAllFactions();
    List<Army> selectAllArmies();
    List<Unit> selectAllUnits();

    Optional<Faction> selectFactionById(int id);
    Optional<Army> selectArmyById(int id);
    Optional<Unit> selectUnitById(int id);

    int deleteFactionById(int id);
    int deleteArmyById(int id);
    int deleteUnitById(int id);

    int updateFactionById(int id, Faction faction);
    int updateArmyById(int id, Army army);
    int updateUnitById(int id, Unit unit);
}
