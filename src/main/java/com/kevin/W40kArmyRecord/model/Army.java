package com.kevin.W40kArmyRecord.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Army {
    private final int army_id;
    @NotNull
    private final int faction_id;
    @NotBlank
    private final String army_name;

    public Army(@JsonProperty("id") int army_id,
                @JsonProperty("factionId") int faction_id,
                @JsonProperty("name") String army_name) {
        this.army_id = army_id;
        this.faction_id = faction_id;
        this.army_name = army_name;
    }

    public String getArmyName() {
        return army_name;
    }

    public Integer getArmyId() {
        return army_id;
    }

    public Integer getFactionId() {
        return faction_id;
    }

}
