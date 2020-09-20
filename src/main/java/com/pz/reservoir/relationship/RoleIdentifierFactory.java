package com.pz.reservoir.relationship;

import java.util.UUID;

public class RoleIdentifierFactory {
    RoleIdentifier generate(){
        return new RoleIdentifier(UUID.randomUUID().toString());
    }

    RoleIdentifier of(String partyId){
        return new RoleIdentifier(UUID.fromString(partyId).toString());
    }
}
