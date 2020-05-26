package com.kevin.W40kArmyRecord.api;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Unit;
import com.kevin.W40kArmyRecord.service.ArmyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/armies")
@RestController
public class ArmyController {

    private final ArmyService armyService;

    @Autowired
    public ArmyController(ArmyService armyService) {
        this.armyService = armyService;
    }

    @PostMapping
    public void addArmy(@Valid @NonNull @RequestBody Army army) {
        armyService.addArmy(army);
    }

    @GetMapping(path = "/all")
    public List<Army> getAllArmies() {
        return armyService.getAllArmies();
    }

    @GetMapping(path = "{id}")
    public Army getArmyById(@PathVariable("id") int id) {
        return armyService.getArmyById(id)
                .orElse(null);
    }

    @GetMapping(path = "/list/{id}")
    public List<Unit> getUnitsInArmy(@PathVariable("id") int id) {
        return armyService.getUnitsInArmy(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteArmyById(@PathVariable("id") int id) {
        armyService.deleteArmy(id);
    }

    @PutMapping(path = "{id}")
    public void updateArmy(@PathVariable("id") int id, @Valid @NonNull @RequestBody Army armyToUpdate){
        armyService.updateArmy(id, armyToUpdate);
    }

}
