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
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.VehicleOwnership;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
public class ClientFacade {

    private final PartyRepository<Person> partyRepository;
    private final PartyRepository<Car> carRepository;
    private final PartyRelationShipRepository<VehicleOwnership> vehicleOwnershipPartyRelationShipRepository;
    public PartyId addClient(Client client){
        var telecomAddress = new TelecomAddress(client.getPhoneNumber());
        List<Address> addresses = Objects.isNull(client.getEmail()) ? List.of(telecomAddress) : List.of(telecomAddress, new EmailAddress(client.getEmail()));
        var person = PartyFactory.createPerson(addresses, List.of(), Set.of(), client.getFirstName(), client.getLastName());
        return partyRepository.save(person);
    }

    public RelationshipIdentifier addCar(ClientPreferences car){
        PartyId carId = createCar(car);
        var vehicleOwnership = RelationshipFactory.createOwnershipRelation(PartyIdFactory.of(car.getOwnerId()), carId);
        return vehicleOwnershipPartyRelationShipRepository.save(vehicleOwnership);

    }

    public Person getClient(PartyId id){
        return partyRepository.find(id);
    }

    public Car getCar(PartyId id){
        return carRepository.find(id);
    }

    public VehicleOwnership getRelationship(RelationshipIdentifier id){
        return vehicleOwnershipPartyRelationShipRepository.find(id);
    }


    private PartyId createCar(ClientPreferences car) {
        List<RegisteredIdentifier> identifiers = List.of(new CarRegistrationNumber(car.getRegistrationNumber()));
//        TODO service type to be moved to some kind catalog
//        Preference serviceOption = PreferenceFactory.generate(preferenceTypeRepository.find(PreferenceIdFactory.of(car.getPreferenceId())), car.getServiceOption().name());
//        relationship to organization unit
//        Preference storage = PreferenceFactory.generate(preferenceTypeRepository.find(PreferenceIdFactory.of(car.getPreferenceId())), car.getTiresStorage().name());
        var vehicle = PartyFactory.createCar(List.of(), identifiers, Set.of(), car.getCarType().name(), car.getRimDiameter(), car.getDisplayName());
        return carRepository.save(vehicle);
    }
}
