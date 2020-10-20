package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.reservation.dto.ReservationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

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
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        var request = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate());
        reservationFacade.reserve(request);

        //when
        //then
        assertThrows(DateUnavailableException.class, () -> reservationFacade.reserve(request));


    }

    @Test
    void reservationShouldBeRejectedForReservationInAnotherReservation() {
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        var initialRequest = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate());
        reservationFacade.reserve(initialRequest);

        var newRequest = new ReservationRequest(now.plus(5, ChronoUnit.MINUTES), Duration.ofMinutes(10), PartyIdFactory.generate(), PartyIdFactory.generate());

        //when
        //then
        assertThrows(DateUnavailableException.class, () -> reservationFacade.reserve(newRequest));

    }

    @Test
    void reservationShouldBeRejectedForReservationOverlappingByEndDate() {
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        var initialRequest = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate());
        reservationFacade.reserve(initialRequest);

        var newRequest = new ReservationRequest(now.minus(5, ChronoUnit.MINUTES), Duration.ofMinutes(10), PartyIdFactory.generate(), PartyIdFactory.generate());

        //when
        //then
        assertThrows(DateUnavailableException.class, () -> reservationFacade.reserve(newRequest));

    }

    @Test
    void reservationShouldBeRejectedForReservationOverlappingByStartDate() {

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