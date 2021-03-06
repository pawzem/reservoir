package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public class PartyFactory {
    public static Person createPerson(List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences, String firstName, String surname){
        var partyId = PartyIdFactory.generate();
        return new Person(partyId, addresses, identifiers, preferences, firstName, surname);
    }

    public static Car createCar(List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences, String carType, String displayName){
        var partyId = PartyIdFactory.generate();
        return new Car(partyId, addresses, identifiers, preferences, displayName, carType);
    }

    public static Company createCompany(String name, List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences) {
        var partyId = PartyIdFactory.generate();
        var organizationName = new OrganizationName(name);
        return new Company(organizationName, partyId, addresses, identifiers, preferences);
    }

    public static OrganizationUnit createUnit(String name, List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences) {
        var partyId = PartyIdFactory.generate();
        var organizationName = new OrganizationName(name);
        return new OrganizationUnit(partyId, organizationName, addresses, identifiers, preferences);
    }
}
