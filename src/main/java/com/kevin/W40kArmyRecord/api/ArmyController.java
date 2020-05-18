package com.kevin.W40kArmyRecord.api;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.service.WarhammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/armies")
@RestController
public class ArmyController {

    private final WarhammerService warhammerService;

    @Autowired
    public ArmyController(WarhammerService warhammerService) {
        this.warhammerService = warhammerService;
    }

    @PostMapping
    public void addArmy(@Valid @NonNull @RequestBody Army army) {
        warhammerService.addArmy(army);
    }

    @GetMapping
    public List<Army> getAllArmies() {
        return warhammerService.getAllArmies();
    }

    @GetMapping(path = "{id}")
    public Army getArmyById(@PathVariable("id") int id) {
        return warhammerService.getArmyById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteArmyById(@PathVariable("id") int id) {
        warhammerService.deleteArmy(id);
    }

    @PutMapping(path = "{id}")
    public void updateArmy(@PathVariable("id") int id, @Valid @NonNull @RequestBody Army armyToUpdate){
        warhammerService.updateArmy(id, armyToUpdate);
    }

}
