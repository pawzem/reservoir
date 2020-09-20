package com.pz.reservoir.relationship;

import com.pz.reservoir.party.PartyId;

public abstract class PartyRoleType {
    private String name;
    private String description;

    abstract boolean canPlayRole(PartyId partyId);
}
