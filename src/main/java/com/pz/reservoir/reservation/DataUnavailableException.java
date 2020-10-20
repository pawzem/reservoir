package com.pz.reservoir.reservation;


import com.pz.reservoir.party.PartyId;

import java.time.Duration;
import java.time.LocalDateTime;

class DataUnavailableException extends RuntimeException{

    private final static  String  MESSAGE_TEMPLATE = "Could not reserve '%s' for duration '%s'  for client '%s' since date is already taken";

    DataUnavailableException(PartyId client, LocalDateTime startTime, Duration duration) {
        super(String.format(MESSAGE_TEMPLATE, startTime, duration, client));
    }
}
