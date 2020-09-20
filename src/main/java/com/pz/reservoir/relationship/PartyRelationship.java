package com.pz.reservoir.relationship;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PartyRelationship {
    private String name;
    private String description;
    private PartyRole clientPartyRole;
    private PartyRole supplierPartyRole;
    private String relationshipIdentifier;
    private PartyRelationshipType partyRelationshipType;
}
