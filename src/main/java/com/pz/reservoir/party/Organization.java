package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public abstract class Organization extends Party{
    private OrganizationName organizationName;

    Organization(PartyId partyId, OrganizationName organizationName, List<Address> addresses, List<RegisteredIdentifier> identifier, Set<Preference> preferences) {
        super(partyId, addresses, identifier, preferences);
    }

    @Override
    public String getName() {
        return organizationName.toString();
    }
}
