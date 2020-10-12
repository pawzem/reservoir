package com.pz.reservoir.buisness;

import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.CompanyBranch;

import java.util.HashMap;
import java.util.Map;

public class BranchRelationshipInMemoryRepository implements PartyRelationShipRepository<CompanyBranch> {

    private final Map<RelationshipIdentifier, CompanyBranch> relationshipBranch = new HashMap<>();

    @Override
    public RelationshipIdentifier save(CompanyBranch relationship) {
        relationshipBranch.put(relationship.getRelationshipIdentifier(), relationship);
        return relationship.getRelationshipIdentifier();
    }

    @Override
    public CompanyBranch find(RelationshipIdentifier relationship) {
        return relationshipBranch.get(relationship);
    }
}
