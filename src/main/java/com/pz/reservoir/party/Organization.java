package com.pz.reservoir.party;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Organization extends Party{
    private OrganizationName organizationName;

    Organization(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier) {
        super(partyId, addresses, identifier);
    }

    @Override
    String getName() {
        return organizationName.toString();
    }
}
