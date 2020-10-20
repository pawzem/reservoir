package com.pz.reservoir.reservation;

import java.time.LocalDate;
import java.util.Optional;

public interface ScheduleRepository<S extends Schedule>  {
    ScheduleId save(S schedule);
    S find(ScheduleId id);

    Optional<S> findByDate(LocalDate date);

    Optional<S> findByReservation(ReservationId reservationId);
}
