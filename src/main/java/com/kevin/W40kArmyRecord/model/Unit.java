package com.kevin.W40kArmyRecord.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Unit {
    private final int unit_id;
    @NotNull
    private final int army_id;
    @NotBlank
    private final String unit_name;
    @NotNull
    private final int total_number;

    public Unit(@JsonProperty("id") int unit_id,
                @JsonProperty("armyId") int army_id,
                @JsonProperty("name") String unit_name,
                @JsonProperty("total_number") int total_number) {
        this.unit_id = unit_id;
        this.army_id = army_id;
        this.unit_name = unit_name;
        this.total_number = total_number;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public Integer getArmy_id() {
        return army_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public Integer getUnitCount() {
        return total_number;
    }

}
