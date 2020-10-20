package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;

public class UnauthorizedCancelAttemptException extends RuntimeException{

    private final static  String  MESSAGE_TEMPLATE = "User '%s' is not authorized to cancel reservation '%s'";

    UnauthorizedCancelAttemptException(PartyId requester, ReservationId reservationId) {
        super(String.format(MESSAGE_TEMPLATE, requester, reservationId));
    }
}
