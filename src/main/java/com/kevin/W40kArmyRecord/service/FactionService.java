package com.kevin.W40kArmyRecord.service;

import com.kevin.W40kArmyRecord.dao.WarhammerDao;
import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactionService {
    private final WarhammerDao warhammerDao;

    public FactionService(@Qualifier("postgres") WarhammerDao warhammerDao) {
        this.warhammerDao = warhammerDao;
    }

    public int addFaction(Faction faction) {
        return warhammerDao.insertFaction(faction);
    }

    public List<Faction> getAllFactions() {
        return warhammerDao.selectAllFactions();
    }

    public Optional<Faction> getFactionById(int id) {
        return warhammerDao.selectFactionById(id);
    }

    public List<Army> getArmiesInFaction(int id) {
        return warhammerDao.selectArmiesInFactionById(id);
    }

    public int deleteFaction(int id) {
        return warhammerDao.deleteFactionById(id);
    }

    public int updateFaction(int id, Faction newFaction) {
        return warhammerDao.updateFactionById(id, newFaction);
    }
}
