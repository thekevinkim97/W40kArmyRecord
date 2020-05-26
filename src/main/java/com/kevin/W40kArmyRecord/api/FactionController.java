package com.kevin.W40kArmyRecord.api;

import com.kevin.W40kArmyRecord.model.Army;
import com.kevin.W40kArmyRecord.model.Faction;
import com.kevin.W40kArmyRecord.service.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/factions")
@RestController
public class FactionController {

    private final FactionService factionService;

    @Autowired
    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }

    @PostMapping
    public void addFaction(@Valid @NonNull @RequestBody Faction faction) {
        factionService.addFaction(faction);
    }

    @GetMapping(path = "/all")
    public List<Faction> getAllFactions() {
        return factionService.getAllFactions();
    }

    @GetMapping(path = "{id}")
    public Faction getFactionById(@PathVariable("id") int id) {
        return factionService.getFactionById(id)
                .orElse(null);
    }

    @GetMapping(path = "/list/{id}")
    public List<Army> getArmiesInFaction(@PathVariable("id") int id) {
        return factionService.getArmiesInFaction(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFactionById(@PathVariable("id") int id) {
        factionService.deleteFaction(id);
    }

    @PutMapping(path ="{id}")
    public void updateFaction(@PathVariable("id") int id, @Valid @NonNull @RequestBody Faction factionToUpdate) {
        factionService.updateFaction(id, factionToUpdate);
    }

}
