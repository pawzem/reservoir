package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.*;
import com.pz.reservoir.party.PartyIdFactory;
import com.pz.reservoir.preference.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ClientFacadeTest {

    private final PreferenceTypeRepository preferenceTypeRepository = new PreferenceTypeInMemoryRepository();
    private final ClientFacade clientFacade = new ClientFacade(new ClientInMemoryRepository(), new CarInMemoryRepository(), preferenceTypeRepository);


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
    void carShouldBeAdded() {
        //given
        var preference = new PreferenceType(PreferenceIdFactory.generate(),
                "sezonal_preferencce",
                "option for changing tires in season",
                Set.of(new PreferenceOption(TireStorage.PROVIDED.name(), "dummy desc"),
                        new PreferenceOption(TireStorage.WAREHOUSE.name(), "dummy desc"),
                        new PreferenceOption(ServiceOption.JUST_TIRES.name(), "dummy desc"),
                        new PreferenceOption(ServiceOption.WHOLE_WHEELS.name(), "dummy desc")
                        ));
        var preferenceId = preferenceTypeRepository.save(preference);

        var carDto = new ClientPreferences(PartyIdFactory.generate().getId(),
                CarType.CAR,
                TireStorage.WAREHOUSE,
                ServiceOption.JUST_TIRES,
                "17'",
                "SK12345",
                "BMW M4",
                preferenceId.getId()
                );

        //when
        var carId = clientFacade.addCar(carDto);

        //then
        assertAll(
                () -> assertNotNull(carId),
                () -> assertNotNull(clientFacade.getCar(carId))
        );

    }

    @Test
    void preferencesShouldBeAdded() {
    }

    @Test
    void preferencesOutOfPreferenceTypeShouldNotBeAdded() {

    }
}