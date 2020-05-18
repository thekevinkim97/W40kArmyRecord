package com.kevin.W40kArmyRecord.api;

import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.service.WarhammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/factions")
@RestController
public class FactionController {

    private final WarhammerService warhammerService;

    @Autowired
    public FactionController(WarhammerService warhammerService) {
        this.warhammerService = warhammerService;
    }

    @PostMapping
    public void addFaction(@Valid @NonNull @RequestBody Faction faction) {
        warhammerService.addFaction(faction);
    }

    @GetMapping
    public List<Faction> getAllFactions() {
        return warhammerService.getAllFactions();
    }

    @GetMapping(path = "{id}")
    public Faction getFactionById(@PathVariable("id") int id) {
        return warhammerService.getFactionById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFactionById(@PathVariable("id") int id) {
        warhammerService.deleteFaction(id);
    }

    @PutMapping(path ="{id}")
    public void updateFaction(@PathVariable("id") int id, @Valid @NonNull @RequestBody Faction factionToUpdate) {
        warhammerService.updateFaction(id, factionToUpdate);
    }

}
