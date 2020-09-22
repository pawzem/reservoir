package com.pz.reservoir.relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PartyRelationshipType {
    private String name;
    private String description;

    public abstract boolean canFormRelationship(PartyRole clientRole, PartyRole supplierRole);
}
