package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.ClientDto;
import com.pz.reservoir.client.dto.ClientWithoutTires;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.identifiers.CarRegistrationNumber;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ClientFacade {

    private final PartyRepository<Person> partyRepository;

    public PartyId addClientWithoutTires(ClientWithoutTires clientWithoutTires){
        List<Address> addresses = List.of(new TelecomAddress(clientWithoutTires.getPhoneNumber()));
        //TODO add preference for missing tires
        var person = PartyFactory.createPerson(addresses, List.of(), clientWithoutTires.getFirstName(), clientWithoutTires.getLastName());
        return partyRepository.save(person);
    }

    public PartyId addClient(ClientDto clientDto){
        List<Address> addresses = List.of(new TelecomAddress(clientDto.getPhoneNumber()));
        List<RegisteredIdentifier> identifiers = List.of(new CarRegistrationNumber(clientDto.getCarId()));
        //TODO add options for additional parameters
        var person = PartyFactory.createPerson(addresses, identifiers, clientDto.getFirstName(), clientDto.getLastName());
        return partyRepository.save(person);
    }
}
