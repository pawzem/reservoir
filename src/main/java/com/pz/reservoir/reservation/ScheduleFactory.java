package com.pz.reservoir.reservation;

import java.time.LocalDate;
import java.util.HashSet;

class ScheduleFactory {

    static Schedule createNew(LocalDate date){
        return new Schedule(ScheduleId.of(), date, new HashSet<>());
    }
}
