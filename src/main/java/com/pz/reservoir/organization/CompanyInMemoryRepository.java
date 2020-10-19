package com.pz.reservoir.organization;

import com.pz.reservoir.party.Company;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;

import java.util.HashMap;
import java.util.Map;

public class CompanyInMemoryRepository implements PartyRepository<Company> {

    private final Map<PartyId, Company> organizationMap = new HashMap<>();

    @Override
    public PartyId save(Company party) {
        organizationMap.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public Company find(PartyId id) {
        return organizationMap.get(id);
    }
}
