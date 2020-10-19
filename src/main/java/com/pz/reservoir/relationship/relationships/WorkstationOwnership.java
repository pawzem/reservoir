package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.relationship.PartyRelationship;
import com.pz.reservoir.relationship.RelationshipIdentifier;

public class WorkstationOwnership extends PartyRelationship<Workstation, UnitWithWorkstations> {
    public WorkstationOwnership(Workstation clientPartyRole, UnitWithWorkstations supplierPartyRole, RelationshipIdentifier relationshipIdentifier) {
        super("Branch workstation relationship", "Relationship between workstation and organization unit in which it is placed", clientPartyRole, supplierPartyRole, relationshipIdentifier);
    }
}
