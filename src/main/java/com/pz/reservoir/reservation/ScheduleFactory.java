package com.pz.reservoir.reservation;

import java.time.LocalDate;

class ScheduleFactory {

    static Schedule createNew(LocalDate date){
        return new Schedule(ScheduleId.of(), date);
    }
}
