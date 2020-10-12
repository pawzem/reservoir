package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.*;
import com.pz.reservoir.party.PartyIdFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ClientFacadeTest {

    private final ClientFacade clientFacade = new ClientFacade(new ClientInMemoryRepository(),
            new CarInMemoryRepository(),
            new VehicleOwnershipInMemoryRepository());


    @Test
    void clientShouldBeAdded() {
        //given
        var clientDto = new Client( "PL +48 500 000 000", "dummy@email", "paweł", "name");

        //when
        var personId = clientFacade.addClient(clientDto);

        //then
        assertAll(
                () -> assertNotNull(personId),
                () -> assertNotNull(clientFacade.getClient(personId))
        );

    }

    @Test
    void ownershipShouldBeAdded() {
        //given

        var carDto = new ClientPreferences(PartyIdFactory.generate().getId(),
                CarType.CAR,
                TireStorage.WAREHOUSE,
                ServiceOption.JUST_TIRES,
                List.of("17'"),
                "SK12345",
                "BMW M4"
                );

        //when
        var ownershipId = clientFacade.addCar(carDto);

        //then
        assertAll(
                () -> assertNotNull(ownershipId),
                () -> assertNotNull(clientFacade.getRelationship(ownershipId))
        );

    }

    @Test
    void carShouldBeAdded() {
        //given

        var carDto = new ClientPreferences(PartyIdFactory.generate().getId(),
                CarType.CAR,
                TireStorage.WAREHOUSE,
                ServiceOption.JUST_TIRES,
                List.of("17'"),
                "SK12345",
                "BMW M4"
        );


        //when
        var ownershipId = clientFacade.addCar(carDto);

        //then
        assertAll(
                () -> assertNotNull(ownershipId),
                () -> assertNotNull(clientFacade.getRelationship(ownershipId)),
                () -> assertNotNull(clientFacade.getCar(clientFacade.getRelationship(ownershipId).getClientPartyRole().getParty()))
        );

    }

}