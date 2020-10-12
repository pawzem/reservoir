package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public class OrganizationUnit extends Organization{

    OrganizationUnit(PartyId partyId,OrganizationName name, List<Address> addresses, List<RegisteredIdentifier> identifier, Set<Preference> preferences) {
        super(partyId,name, addresses, identifier, preferences);
    }

}
