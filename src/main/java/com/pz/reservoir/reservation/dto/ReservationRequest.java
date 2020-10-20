package com.pz.reservoir.reservation.dto;

import com.pz.reservoir.party.PartyId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReservationRequest {
    private final LocalDateTime startTime;
    private final Duration duration;
    private final PartyId workstation;
    private final PartyId client;
}
