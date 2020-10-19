package com.pz.reservoir.person;

import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.Employment;

import java.util.HashMap;
import java.util.Map;

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
}
