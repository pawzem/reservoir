package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.relationship.PartyRelationship;
import com.pz.reservoir.relationship.RelationshipIdentifier;

public class VehicleOwnership extends PartyRelationship<Vehicle, VehicleOwner> {

    public VehicleOwnership(Vehicle vehicle, VehicleOwner owner, RelationshipIdentifier id) {
        super("vehicle ownership", "relationship between owner and it's vehicle", vehicle, owner, id);
    }

}
