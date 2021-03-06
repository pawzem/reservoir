package com.pz.reservoir.organization;

import com.pz.reservoir.party.OrganizationUnit;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.PartyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BranchInMemoryRepository implements PartyRepository<OrganizationUnit> {

    private final Map<PartyId, OrganizationUnit> organizationMap = new HashMap<>();

    @Override
    public PartyId save(OrganizationUnit party) {
        organizationMap.put(party.getPartyId(), party);
        return party.getPartyId();
    }

    @Override
    public OrganizationUnit find(PartyId id) {
        return organizationMap.get(id);
    }

    @Override
    public List<OrganizationUnit> findAll() {
        return List.copyOf(organizationMap.values());
    }
}
