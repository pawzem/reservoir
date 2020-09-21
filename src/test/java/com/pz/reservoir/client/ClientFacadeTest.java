package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ClientFacadeTest {

    private ClientFacade clientFacade = new ClientFacade(new ClientInMemoryRepository());



    @Test
    void clientShouldBeAdded() {
        //given
        var clientDto = new Client("SK12345", "PL +48 500 000 000", "dummy@email", "paweł", "name");

        //when
        var personId = clientFacade.addClient(clientDto);

        //then
        assertAll(
                () -> assertNotNull(personId),
                () -> assertNotNull(clientFacade.getClient(personId))
        );

    }

    @Test
    void preferencesShouldBeAdded() {
    }

    @Test
    void preferencesOutOfPreferenceTypeShouldNotBeAdded() {
    }
}