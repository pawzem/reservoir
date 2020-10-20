package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
class Reservation {
    private final ReservationId id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final PartyId client;

    boolean isAvailable(LocalDateTime askedStartTime, LocalDateTime askedEndTime){
        return askedStartTime.isBefore(askedEndTime) && (startTime.isAfter(askedEndTime) || endTime.isBefore(askedStartTime));

    }
}
