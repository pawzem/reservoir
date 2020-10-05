package com.pz.reservoir.client;

import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.VehicleOwnership;

import java.util.HashMap;
import java.util.Map;

public class VehicleOwnershipInMemoryRepository implements PartyRelationShipRepository<VehicleOwnership> {

    private Map<RelationshipIdentifier, VehicleOwnership> relationshipMap = new HashMap<>();

    @Override
    public RelationshipIdentifier save(VehicleOwnership relation) {
        relationshipMap.put(relation.getRelationshipIdentifier(), relation);
        return relation.getRelationshipIdentifier();
    }

    @Override
    public VehicleOwnership find(RelationshipIdentifier id) {
        return relationshipMap.get(id);
    }

}
