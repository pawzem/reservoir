package com.pz.reservoir.party;

import java.util.List;

public class PartyFactory {
    public static Person createPerson(List<Address> addresses, List<RegisteredIdentifier> identifiers, String firstName, String surname){
        var partyId = PartyIdFactory.generate();
        return new Person(partyId, addresses, identifiers, firstName, surname);
    }
}
