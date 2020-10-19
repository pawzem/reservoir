package com.pz.reservoir.organization;

import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;

import java.util.HashMap;
import java.util.Map;

public class WorkstationRelationshipInMemoryRepository implements PartyRelationShipRepository<WorkstationOwnership> {

    private final Map<RelationshipIdentifier, WorkstationOwnership> workstationRelationships = new HashMap<>();

    @Override
    public RelationshipIdentifier save(WorkstationOwnership relationship) {
        workstationRelationships.put(relationship.getRelationshipIdentifier(), relationship);
        return relationship.getRelationshipIdentifier();
    }

    @Override
    public WorkstationOwnership find(RelationshipIdentifier relationship) {
        return workstationRelationships.get(relationship);
    }
}
