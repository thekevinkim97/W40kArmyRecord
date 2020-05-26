package com.kevin.W40kArmyRecord.service;

import com.kevin.W40kArmyRecord.dao.WarhammerDao;
import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Unit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmyService {
    private final WarhammerDao warhammerDao;

    public ArmyService(@Qualifier("postgres") WarhammerDao warhammerDao) {
        this.warhammerDao = warhammerDao;
    }

    public int addArmy(Army army) {
        return warhammerDao.insertArmy(army);
    }

    public List<Army> getAllArmies() {
        return warhammerDao.selectAllArmies();
    }

    public Optional<Army> getArmyById(int id) {
        return warhammerDao.selectArmyById(id);
    }

    public List<Unit> getUnitsInArmy(int id) {
        return warhammerDao.selectUnitsInArmyById(id);
    }

    public int deleteArmy(int id) {
        return warhammerDao.deleteArmyById(id);
    }

    public int updateArmy(int id, Army newArmy) {
        return  warhammerDao.updateArmyById(id, newArmy);
    }
}
