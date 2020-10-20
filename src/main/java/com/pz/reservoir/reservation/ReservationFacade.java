package com.pz.reservoir.reservation;

import com.pz.reservoir.reservation.dto.ReservationRequest;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ReservationFacade {

    public ReservationId reserve(ReservationRequest reservation){
        return ReservationId.of();
    }

    public ReservationId cancel(ReservationId reservationId){
        return ReservationId.of();
    }

    public boolean isAvailable(LocalDateTime now, Duration serviceDuration) {
        return true;
    }
}
