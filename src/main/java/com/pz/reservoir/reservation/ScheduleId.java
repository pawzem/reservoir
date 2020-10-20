package com.pz.reservoir.reservation;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class ScheduleId {
    private final UUID id;

    protected ScheduleId(UUID id) {
        this.id = id;
    }

    private String getIdValue() {
        return id.toString();
    }

    public static ScheduleId of(){
        return new ScheduleId(UUID.randomUUID());
    }

    public static ScheduleId of(String id){
        return new ScheduleId(UUID.fromString(id));
    }
}
