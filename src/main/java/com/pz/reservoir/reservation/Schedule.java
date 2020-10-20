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
    private final PartyId workstationId;

    private final Set<Reservation> reservations;


    ReservationId reserve(ReservationPolicy reservationPolicy, PartyId client, LocalDateTime startTime, Duration duration) {

        if(reservationPolicy.canReserve(this, client, startTime, duration)){
            var reservation = new Reservation(ReservationId.of(), startTime, startTime.plus(duration), client);
            reservations.add(reservation);

            return reservation.getId();
        } else {
            throw new DateUnavailableException(client, startTime, duration);
        }

    }

    ReservationId cancel(CancelPolicy cancelPolicy,PartyId requesterId,  ReservationId reservationId){
        //TODO cancel policy
        reservations.removeIf(reservation -> {
            return  reservation.getId().equals(reservationId) && cancelPolicy.validateCancel(workstationId, requesterId, reservation);
        });
        return reservationId;
    }

    boolean isReserved(LocalDateTime dateTime, Duration serviceDuration) {
        return reservations.stream()
                .filter(r -> r.doesCollide(dateTime, dateTime.plus(serviceDuration)))
                .findAny()
                .isEmpty();
    }

    boolean contains(ReservationId reservationId) {
        return reservations.stream()
                .anyMatch(r -> r.getId().equals(reservationId));
    }
}
