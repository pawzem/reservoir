package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;

import java.util.List;
import java.util.Set;

public abstract class OrganizationUnit extends Organization{

    OrganizationUnit(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier, Set<Preference> preferences) {
        super(partyId, addresses, identifier, preferences);
    }

}
