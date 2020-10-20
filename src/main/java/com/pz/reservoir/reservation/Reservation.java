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

    boolean doesCollide(LocalDateTime askedStartTime, LocalDateTime askedEndTime){
        return !(endTimeAfterStartTime(askedStartTime, askedEndTime) && (endBeforeReservationStarts(askedEndTime) || startsAfterReservationEnds(askedStartTime)));

    }

    private boolean startsAfterReservationEnds(LocalDateTime askedStartTime) {
        return endTime.isBefore(askedStartTime);
    }

    private boolean endBeforeReservationStarts(LocalDateTime askedEndTime) {
        return startTime.isAfter(askedEndTime);
    }

    private boolean endTimeAfterStartTime(LocalDateTime askedStartTime, LocalDateTime askedEndTime) {
        return askedStartTime.isBefore(askedEndTime);
    }
}
