package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.relationship.PartyRelationshipType;
import com.pz.reservoir.relationship.PartyRole;
import com.pz.reservoir.relationship.roles.VehicleOwner;

public class VehicleOwnership extends PartyRelationshipType {

    public VehicleOwnership(String name, String description) {
        super("vehicle ownership", "relationship between owner and it's vehicle");
    }

    @Override
    public boolean canFormRelationship(PartyRole clientRole, PartyRole supplierRole) {
        return supplierRole.getPartyRoleType() instanceof VehicleOwner;
    }
}
