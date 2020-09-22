package com.pz.reservoir.client;

import com.pz.reservoir.client.dto.Client;
import com.pz.reservoir.client.dto.ClientPreferences;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.EmailAddress;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.identifiers.CarRegistrationNumber;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.preference.PreferenceFactory;
import com.pz.reservoir.preference.PreferenceIdFactory;
import com.pz.reservoir.preference.PreferenceTypeRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
public class ClientFacade {

    private final PartyRepository<Person> partyRepository;
    private final PartyRepository<Car> carRepository;
    private final PreferenceTypeRepository preferenceTypeRepository;

    public PartyId addClient(Client client){
        var telecomAddress = new TelecomAddress(client.getPhoneNumber());
        List<Address> addresses = Objects.isNull(client.getEmail()) ? List.of(telecomAddress) : List.of(telecomAddress, new EmailAddress(client.getEmail()));
        var person = PartyFactory.createPerson(addresses, List.of(), Set.of(), client.getFirstName(), client.getLastName());
        return partyRepository.save(person);
    }

    public PartyId addCar(ClientPreferences car){
        List<RegisteredIdentifier> identifiers = List.of(new CarRegistrationNumber(car.getRegistrationNumber()));
        Preference serviceOption = PreferenceFactory.generate(preferenceTypeRepository.find(PreferenceIdFactory.of(car.getPreferenceId())), car.getServiceOption().name());
        Preference storage = PreferenceFactory.generate(preferenceTypeRepository.find(PreferenceIdFactory.of(car.getPreferenceId())), car.getTiresStorage().name());
        var vehicle = PartyFactory.createCar(List.of(), identifiers, Set.of(serviceOption, storage), car.getCarType().name(), car.getRimDiameter(), car.getDisplayName());

        //TODO add relation to owner
        return carRepository.save(vehicle);

    }

    public Person getClient(PartyId id){
        return partyRepository.find(id);
    }

    public Car getCar(PartyId id){
        return carRepository.find(id);
    }

}
