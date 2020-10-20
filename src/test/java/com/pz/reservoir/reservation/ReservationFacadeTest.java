package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.reservation.dto.ReservationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFacadeTest {

    private ReservationFacade reservationFacade;

    @BeforeEach
    void setUp() {
        var reservationConfig = new ReservationConfiguration();
        reservationFacade = reservationConfig.reservationFacade(new ScheduleInMemoryRepository());
    }

    @Test
    void reservationShouldBeMadeInAvailableSlot() {
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        var request = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate());

        //when
        ScheduleId scheduleId = reservationFacade.reserve(request);

        //then
        assertAll(
                () -> assertNotNull(scheduleId),
                () -> assertFalse(reservationFacade.isAvailable(now, serviceDuration))
        );


    }

    @Test
    void reservationShouldBeRejectedForAlreadyTakenDate() {

    }

    @Test
    void reservationShouldBeRejectedForOverlappingDate() {

    }

    @Test
    void reservationShouldBeRejectedIfClientAlreadyScheduledSlotsExceeded() {

    }

    @Test
    void reservationShouldBeRejectedIfClientIsBlocked() {

    }

    @Test
    void reservationShouldBeCancelled() {

    }

}