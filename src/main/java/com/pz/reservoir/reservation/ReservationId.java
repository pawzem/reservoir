package com.pz.reservoir.reservation;

import java.util.UUID;

public class ReservationId {
    private final UUID id;

    protected ReservationId(UUID id) {
        this.id = id;
    }

    private String getIdValue() {
        return id.toString();
    }

    public static ReservationId of(){
        return new ReservationId(UUID.randomUUID());
    }

    public static ReservationId of(String id){
        return new ReservationId(UUID.fromString(id));
    }
}
