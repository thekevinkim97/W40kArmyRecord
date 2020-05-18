package com.kevin.W40kArmyRecord.api;


import com.kevin.W40kArmyRecord.model.Unit;
import com.kevin.W40kArmyRecord.service.WarhammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/units")
@RestController
public class UnitController {

    private final WarhammerService warhammerService;

    @Autowired
    public UnitController(WarhammerService warhammerService) {
        this.warhammerService = warhammerService;
    }

    @PostMapping
    public void addUnit(@Valid @NonNull @RequestBody Unit unit) {
        warhammerService.addUnit(unit);
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return warhammerService.getAllUnits();
    }

    @GetMapping(path = "{id}")
    public Unit getUnitById(@PathVariable("id") int id) {
        return warhammerService.getUnitById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUnitById(@PathVariable("id") int id) {
        warhammerService.deleteUnit(id);
    }

    @PutMapping(path = "{id}")
    public void updateUnitById(@PathVariable("id") int id, @Valid @NonNull @RequestBody Unit unitToUpdate) {
        warhammerService.updateUnit(id, unitToUpdate);
    }

}
