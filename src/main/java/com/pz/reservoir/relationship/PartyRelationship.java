package com.pz.reservoir.relationship;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public abstract class PartyRelationship<C extends PartyRole, S extends PartyRole> {
    private String name;
    private String description;
    private C clientPartyRole;
    private S supplierPartyRole;
    private RelationshipIdentifier relationshipIdentifier;
}
