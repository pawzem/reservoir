package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.reservation.dto.ReservationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
        var reservationId = reservationFacade.reserve(request);

        //then
        assertAll(
                () -> assertNotNull(reservationId),
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
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        var initialRequest = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate());
        reservationFacade.reserve(initialRequest);

        var newRequest = new ReservationRequest(now.plus(5, ChronoUnit.MINUTES), Duration.ofMinutes(30), PartyIdFactory.generate(), PartyIdFactory.generate());

        //when
        //then
        assertThrows(DateUnavailableException.class, () -> reservationFacade.reserve(newRequest));

    }


    @Test
    void reservationShouldBeCancelled() {
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        PartyId client = PartyIdFactory.generate();
        var initialRequest = new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), client);
        ReservationId reservationId = reservationFacade.reserve(initialRequest);
        var requester = client;

        //when
        reservationFacade.cancel(requester, reservationId);

        //then
        assertAll(
                () -> assertNotNull(reservationId),
                () -> assertTrue(reservationFacade.isAvailable(now, serviceDuration))
        );
    }

    //implement
    @Disabled
    @Test
    void reservationInTimePeriodShouldBeCancelled() {
        //given
        var now = LocalDateTime.now();
        Duration serviceDuration = Duration.ofMinutes(30);
        reservationFacade.reserve(new ReservationRequest(now, serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate()));
        reservationFacade.reserve(new ReservationRequest(now.plus(1, ChronoUnit.HOURS), serviceDuration, PartyIdFactory.generate(), PartyIdFactory.generate()));

        //when
        reservationFacade.cancel(PartyIdFactory.generate(), now, now.plus(2, ChronoUnit.HOURS));

        //then
        assertAll(
                () -> assertTrue(reservationFacade.isAvailable(now, Duration.ofHours(4)))
        );

    }

    @Test
    void reservationShouldBeRejectedIfClientAlreadyScheduledSlotsExceeded() {
        //TODO
    }

    @Test
    void reservationShouldBeRejectedIfClientIsBlocked() {
        //TODO
    }


}