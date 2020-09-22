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
        var person = PartyFactory.createPerson(addresses, List.of(), Set.of(), client.getFirstName(), client.getLastName());
        return partyRepository.save(person);
    }

    public PartyId addCar(ClientPreferences car){
        List<RegisteredIdentifier> identifiers = List.of(new CarRegistrationNumber(car.getRegistrationNumber()));
        var vehicle = PartyFactory.createCar(List.of(), identifiers, Set.of(), car.getCarType().name(), car.getRimDiameter(), car.getDisplayName());

        //TODO add relation owner
        //TODO add preferences for wheels,storage
        return partyRepository.save(vehicle);

    }

    public Person getClient(PartyId id){
        return partyRepository.find(id);
    }

    //TODO model car as a party
}
