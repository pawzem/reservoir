package com.pz.reservoir.relationship;

import com.pz.reservoir.party.Party;

public abstract class PartyRoleType {
    private String name;
    private String description;

    public abstract boolean canPlayRole(Party party);
}
