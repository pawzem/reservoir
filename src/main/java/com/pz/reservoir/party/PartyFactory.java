package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public class PartyFactory {
    public static Person createPerson(List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences, String firstName, String surname){
        var partyId = PartyIdFactory.generate();
        return new Person(partyId, addresses, identifiers, preferences, firstName, surname);
    }
}
