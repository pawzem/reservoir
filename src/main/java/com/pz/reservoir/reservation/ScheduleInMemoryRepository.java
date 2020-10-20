package com.pz.reservoir.reservation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ScheduleInMemoryRepository implements ScheduleRepository<Schedule> {

    private final Map<ScheduleId, Schedule> scheduleMap = new HashMap<>();

    @Override
    public ScheduleId save(Schedule schedule) {
        scheduleMap.put(schedule.getId(), schedule);
        return schedule.getId();
    }

    @Override
    public Schedule find(ScheduleId id) {
        return scheduleMap.get(id);
    }

    @Override
    public Optional<Schedule> findByDate(LocalDate date) {
        return scheduleMap.values()
                .stream()
                .filter(schedule -> schedule.getDate().equals(date))
                .findAny();
    }

    @Override
    public Optional<Schedule> findByReservation(ReservationId reservationId) {
        return scheduleMap
                .values()
                .stream()
                .filter( s -> s.contains(reservationId))
                .findAny();
    }
}
