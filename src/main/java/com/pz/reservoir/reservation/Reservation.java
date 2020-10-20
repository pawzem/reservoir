package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
class Reservation {
    @Getter(AccessLevel.PACKAGE)
    private final ReservationId id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final PartyId client;

    boolean doesCollide(LocalDateTime askedStartTime, LocalDateTime askedEndTime){
        return !(endTimeAfterStartTime(askedStartTime, askedEndTime) && (endBeforeReservationStarts(askedEndTime) || startsAfterReservationEnds(askedStartTime)));

    }

    private boolean startsAfterReservationEnds(LocalDateTime askedStartTime) {
        return endTime.isBefore(askedStartTime) || endTime.equals(askedStartTime);
    }

    private boolean endBeforeReservationStarts(LocalDateTime askedEndTime) {
        return startTime.isAfter(askedEndTime) || startTime.equals(askedEndTime);
    }

    private boolean endTimeAfterStartTime(LocalDateTime askedStartTime, LocalDateTime askedEndTime) {
        return askedStartTime.isBefore(askedEndTime);
    }
}
