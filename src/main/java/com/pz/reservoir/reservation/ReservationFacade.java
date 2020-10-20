package com.pz.reservoir.reservation;

import com.pz.reservoir.reservation.dto.ReservationRequest;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ReservationFacade {

    public String reserve(ReservationRequest reservation){
        return "";
    }

    public String cancel(String reservationId){
        return "";
    }

    public boolean isAvailable(LocalDateTime now, Duration serviceDuration) {
        return true;
    }
}
