package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class Schedule {

    @Getter(AccessLevel.PACKAGE)
    private final ScheduleId id;
    @Getter(AccessLevel.PACKAGE)
    private final LocalDate date;

    private final Set<Reservation> reservations;


    void reserve(PartyId client, LocalDateTime startTime, Duration duration) {

        if(isAvailable(startTime, duration)){
            reservations.add(new Reservation(ReservationId.of(), startTime, startTime.plus(duration), client));
        } else {
            throw new DataUnavailableException(client, startTime, duration);
        }

    }

    boolean isAvailable(LocalDateTime dateTime, Duration serviceDuration) {
        return reservations.stream()
                .filter(r -> r.doesCollide(dateTime, dateTime.plus(serviceDuration)))
                .findAny()
                .isEmpty();
    }
}
