package com.pz.reservoir.party;

import java.util.List;

public class Person extends Party{

    private PersonName personName;



    Person(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifiers, String firstName, String surname){
        super(partyId, addresses, identifiers);
        this.personName= new PersonName(firstName, surname);
    }


    @Override
    String getName() {
        return personName.toString();
    }
}
