package com.pz.reservoir.person;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.Employment;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmploymentRelationshipInMemoryRepository implements PartyRelationShipRepository<Employment> {

    private final Map<RelationshipIdentifier, Employment> relationshipBranch = new HashMap<>();

    @Override
    public RelationshipIdentifier save(Employment relationship) {
        relationshipBranch.put(relationship.getRelationshipIdentifier(), relationship);
        return relationship.getRelationshipIdentifier();
    }

    @Override
    public Employment find(RelationshipIdentifier relationship) {
        return relationshipBranch.get(relationship);
    }

    @Override
    public List<Employment> findBySupplierId(PartyId partyId) {
        return relationshipBranch.values()
                .stream()
                .filter(relationship -> Objects.equals(relationship.getSupplierPartyRole().getParty(), partyId))
                .collect(Collectors.toList());
    }
}
