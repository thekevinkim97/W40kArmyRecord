package com.kevin.W40kArmyRecord.service;

import com.kevin.W40kArmyRecord.dao.WarhammerDao;
import com.kevin.W40kArmyRecord.model.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    private final WarhammerDao warhammerDao;

    public UnitService(WarhammerDao warhammerDao) {
        this.warhammerDao = warhammerDao;
    }

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
