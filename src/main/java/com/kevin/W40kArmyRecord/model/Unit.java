package com.kevin.W40kArmyRecord.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Unit {
    private final int unit_id;
    @NotBlank
    private final int army_id;
    @NotBlank
    private final int faction_id;
    @NotBlank
    private final String unit_name;

    public Unit(@JsonProperty("id") int unit_id,
                @JsonProperty("armyId") int army_id,
                @JsonProperty("factionId") int faction_id,
                @JsonProperty("name") String unit_name) {
        this.unit_id = unit_id;
        this.army_id = army_id;
        this.faction_id = faction_id;
        this.unit_name = unit_name;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public Integer getFaction_id() {
        return faction_id;
    }

    public String getUnit_name() {
        return unit_name;
    }
}
