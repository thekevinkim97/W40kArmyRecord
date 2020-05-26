package com.kevin.W40kArmyRecord.api;


import com.kevin.W40kArmyRecord.model.Unit;
import com.kevin.W40kArmyRecord.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/units")
@RestController
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public void addUnit(@Valid @NonNull @RequestBody Unit unit) {
        unitService.addUnit(unit);
    }

    @GetMapping(path = "/all")
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping(path = "{id}")
    public Unit getUnitById(@PathVariable("id") int id) {
        return unitService.getUnitById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUnitById(@PathVariable("id") int id) {
        unitService.deleteUnit(id);
    }

    @PutMapping(path = "{id}")
    public void updateUnitById(@PathVariable("id") int id, @Valid @NonNull @RequestBody Unit unitToUpdate) {
        unitService.updateUnit(id, unitToUpdate);
    }

}
