package com.kevin.W40kArmyRecord.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Faction {
    private final int faction_id;
    @NotBlank
    private final String faction_name;

    public Faction(@JsonProperty("id") int faction_id,
                   @JsonProperty("name") String faction_name) {
        this.faction_id = faction_id;
        this.faction_name = faction_name;
    }

    public Integer getFactionId() {
        return faction_id;
    }

    public String getFactionName() {
        return faction_name;
    }
}
