package com.kevin.W40kArmyRecord.service;

import com.kevin.W40kArmyRecord.dao.WarhammerDao;
import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarhammerService {

    private final WarhammerDao warhammerDao;

    @Autowired
    public WarhammerService(@Qualifier("postgres") WarhammerDao warhammerDao) {
        this.warhammerDao = warhammerDao;
    }

    //Faction Methods
    public int addFaction(Faction faction) {
        return warhammerDao.insertFaction(faction);
    }

    public List<Faction> getAllFactions() {
        return warhammerDao.selectAllFactions();
    }

    public Optional<Faction> getFactionById(int id) {
        return warhammerDao.selectFactionById(id);
    }

    public int deleteFaction(int id) {
        return warhammerDao.deleteFactionById(id);
    }

    public int updateFaction(int id, Faction newFaction) {
        return warhammerDao.updateFactionById(id, newFaction);
    }


    //Army Methods
    public int addArmy(Army army) {
        return warhammerDao.insertArmy(army);
    }

    public List<Army> getAllArmies() {
        return warhammerDao.selectAllArmies();
    }

    public Optional<Army> getArmyById(int id) {
        return warhammerDao.selectArmyById(id);
    }

    public int deleteArmy(int id) {
        return warhammerDao.deleteArmyById(id);
    }

    public int updateArmy(int id, Army newArmy) {
        return  warhammerDao.updateArmyById(id, newArmy);
    }


    //Unit Methods
    public int addUnit(Unit unit) {
        return warhammerDao.insertUnit(unit);
    }

    public List<Unit> getAllUnits() {
        return warhammerDao.selectAllUnits();
    }

    public Optional<Unit> getUnitById(int id) {
        return warhammerDao.selectUnitById(id);
    }

    public int deleteUnit(int id) {
        return warhammerDao.deleteUnitById(id);
    }

    public int updateUnit(int id, Unit newUnit) {
        return  warhammerDao.updateUnitById(id, newUnit);
    }
}
