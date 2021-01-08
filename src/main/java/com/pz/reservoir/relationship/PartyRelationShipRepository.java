package com.pz.reservoir.relationship;

import com.pz.reservoir.party.PartyId;

import java.util.List;

public interface PartyRelationShipRepository<R extends PartyRelationship>  {
    RelationshipIdentifier save(R relationship);
    R find(RelationshipIdentifier relationship);
    List<R> findBySupplierId(PartyId partyId);
}
