package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public class Company extends Organization{


    Company(OrganizationName name, PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier, Set<Preference> preferences) {
        super(partyId, name, addresses, identifier, preferences);
    }

}
