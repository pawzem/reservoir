package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public class Person extends Party{

    private PersonName personName;



    Person(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifiers, Set<Preference> preferences, String firstName, String surname){
        super(partyId, addresses, identifiers, preferences);
        this.personName= new PersonName(firstName, surname);
    }


    @Override
    String getName() {
        return personName.toString();
    }
}
