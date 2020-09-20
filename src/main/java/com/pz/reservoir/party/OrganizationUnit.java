package com.pz.reservoir.party;

import java.util.List;

public abstract class OrganizationUnit extends Organization{

    OrganizationUnit(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier) {
        super(partyId, addresses, identifier);
    }

}
