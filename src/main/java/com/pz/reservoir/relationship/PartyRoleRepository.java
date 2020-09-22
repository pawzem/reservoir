package com.pz.reservoir.relationship;

public interface PartyRoleRepository<R extends PartyRoleType> {
    RelationshipIdentifier save(R relationship);
    R find(RelationshipIdentifier relationship);
}
