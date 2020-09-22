package com.pz.reservoir.relationship;

public interface PartyRelationShipRepository<R extends PartyRelationship>  {
    RelationshipIdentifier save(R relationship);
    R find(RelationshipIdentifier relationship);
}
