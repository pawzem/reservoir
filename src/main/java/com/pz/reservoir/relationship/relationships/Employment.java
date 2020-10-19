package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.relationship.PartyRelationship;
import com.pz.reservoir.relationship.RelationshipIdentifier;

public class Employment extends PartyRelationship<Employee, Employer> {
    public Employment(Employee clientPartyRole, Employer supplierPartyRole, RelationshipIdentifier relationshipIdentifier) {
        super("Employment", "Work relationship between employee and employer", clientPartyRole, supplierPartyRole, relationshipIdentifier);
    }
}
