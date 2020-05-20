package com.kevin.W40kArmyRecord.dao;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.model.Unit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakedao")
public class FakeWarhammerDataAccessService implements WarhammerDao {

    private static List<Faction> DB_F = new ArrayList<>();
    private static List<Army> DB_A = new ArrayList<>();
    private static List<Unit> DB_U = new ArrayList<>();


    //Faction Methods
    @Override
    public int insertFaction(int id, Faction faction) {
        DB_F.add(new Faction(id, faction.getFactionName()));
        return 1;
    }
    @Override
    public List<Faction> selectAllFactions() {
        return DB_F;
    }
    @Override
    public Optional<Faction> selectFactionById(int id) {
        return DB_F.stream()
                    .filter(faction -> faction.getFactionId().equals(id))
                    .findFirst();
    }
    @Override
    public int deleteFactionById(int id) {
        Optional<Faction> factionMaybe = selectFactionById(id);
        if(factionMaybe.isEmpty()) {
            return 0;
        }
        DB_F.remove(factionMaybe.get());
        return 1;
    }
    @Override
    public int updateFactionById(int id, Faction updateFaction) {
        return selectFactionById(id)
                .map(faction -> {
                    int indexOfFactionToUpdate = DB_F.indexOf(faction);
                    if (indexOfFactionToUpdate >= 0) {
                        DB_F.set(indexOfFactionToUpdate, new Faction(id, updateFaction.getFactionName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


    //Army Methods
    @Override
    public int insertArmy(int id, Army army) {
        DB_A.add(new Army(id, army.getFactionId(), army.getArmyName()));
        return 1;
    }
    @Override
    public List<Army> selectAllArmies() {
        return DB_A;
    }
    @Override
    public Optional<Army> selectArmyById(int id) {
        return DB_A.stream()
                    .filter(army -> army.getArmyId().equals(id))
                    .findFirst();
    }
    @Override
    public int deleteArmyById(int id) {
        Optional<Army> armyMaybe = selectArmyById(id);
        if (armyMaybe.isEmpty()) {
            return 0;
        }
        DB_A.remove(armyMaybe.get());
        return 1;
    }
    @Override
    public int updateArmyById(int id, Army updateArmy) {
        return selectArmyById(id)
                .map(army -> {
                    int indexOfArmyToUpdate = DB_A.indexOf(army);
                    if (indexOfArmyToUpdate >= 0) {
                        DB_A.set(indexOfArmyToUpdate, new Army(id, updateArmy.getFactionId(), updateArmy.getArmyName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


    //Unit Methods
    @Override
    public int insertUnit(int id, Unit unit) {
        DB_U.add(new Unit(id, unit.getArmy_id(), unit.getUnit_name()));
        return 1;
    }
    @Override
    public List<Unit> selectAllUnits() {
        return DB_U;
    }
    @Override
    public Optional<Unit> selectUnitById(int id) {
        return DB_U.stream()
                    .filter(unit -> unit.getUnit_id().equals(id))
                    .findFirst();
    }
    @Override
    public int deleteUnitById(int id) {
        Optional<Unit> unitMaybe = selectUnitById(id);
        if (unitMaybe.isEmpty()) {
            return 0;
        }
        DB_U.remove((unitMaybe.get()));
        return 1;
    }
    @Override
    public int updateUnitById(int id, Unit updateUnit) {
        return selectUnitById(id)
                .map(unit -> {
                    int indexOfUnitToUpdate = DB_U.indexOf(unit);
                    if (indexOfUnitToUpdate >= 0) {
                        DB_U.set(indexOfUnitToUpdate, new Unit(id, DB_U.get(indexOfUnitToUpdate).getArmy_id(), updateUnit.getUnit_name()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
