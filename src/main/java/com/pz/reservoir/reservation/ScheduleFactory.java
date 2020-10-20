package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;

import java.time.LocalDate;
import java.util.HashSet;

class ScheduleFactory {

    static Schedule createNew(PartyId workstation, LocalDate date){
        return new Schedule(ScheduleId.of(), date,workstation, new HashSet<>());
    }
}
