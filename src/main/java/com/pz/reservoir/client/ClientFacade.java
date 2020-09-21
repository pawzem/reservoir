package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.Client;
import com.pz.reservoir.client.dto.ClientPreferences;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.EmailAddress;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.identifiers.CarRegistrationNumber;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
public class ClientFacade {

    private final PartyRepository<Person> partyRepository;

    public PartyId addClient(Client client){
        var telecomAddress = new TelecomAddress(client.getPhoneNumber());
        List<Address> addresses = Objects.isNull(client.getEmail()) ? List.of(telecomAddress) : List.of(telecomAddress, new EmailAddress(client.getEmail()));
        List<RegisteredIdentifier> identifiers = List.of(new CarRegistrationNumber(client.getCarId()));
        var person = PartyFactory.createPerson(addresses, identifiers, Set.of(), client.getFirstName(), client.getLastName());
        return partyRepository.save(person);
    }

    public PartyId addPreferences(ClientPreferences preferences){
        var person = partyRepository.find(PartyIdFactory.of(preferences.getClientId()));
        //TODO build preferences
        return partyRepository.save(person);

    }

    public Person getClient(PartyId id){
        return partyRepository.find(id);
    }
}
