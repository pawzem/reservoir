package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;

import java.time.Duration;
import java.time.LocalDateTime;

class ReservationPolicy {

    boolean canReserve(Schedule schedule, PartyId client, LocalDateTime startTime, Duration duration){
        //TODO handle blocked clients
        return schedule.isReserved(startTime, duration);
    }

}
