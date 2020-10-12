package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.relationship.PartyRelationship;
import com.pz.reservoir.relationship.RelationshipIdentifier;

public class CompanyBranch  extends PartyRelationship<BranchUnit, BranchOwner> {
    public CompanyBranch(BranchUnit clientPartyRole, BranchOwner supplierPartyRole, RelationshipIdentifier relationshipIdentifier) {
        super("Company branch relationship", "relationship between company and branch", clientPartyRole, supplierPartyRole, relationshipIdentifier);
    }
}
