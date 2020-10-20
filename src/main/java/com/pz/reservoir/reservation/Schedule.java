package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class Schedule {

    @Getter
    private ScheduleId id;
    @Getter
    private final LocalDate date;


    void reserve(PartyId client, LocalDateTime startTime, Duration duration) {

    }
}
