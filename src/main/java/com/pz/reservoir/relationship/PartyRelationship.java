package com.pz.reservoir.relationship;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PartyRelationship {
    private String name;
    private String description;
    private RoleIdentifier clientPartyRole;
    private RoleIdentifier supplierPartyRole;
    private RelationshipIdentifier relationshipIdentifier;
    private PartyRelationshipType partyRelationshipType;
}
