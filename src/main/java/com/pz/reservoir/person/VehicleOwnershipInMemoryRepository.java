package com.pz.reservoir.person;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.Employment;
import com.pz.reservoir.relationship.relationships.VehicleOwnership;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public List<VehicleOwnership> findBySupplierId(PartyId partyId) {
        return relationshipMap.values()
                .stream()
                .filter(relationship -> Objects.equals(relationship.getSupplierPartyRole().getParty(), partyId))
                .collect(Collectors.toList());
    }

}
