package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class BranchOwner extends PartyRole {
    public BranchOwner(PartyId party, Set<Preference> preferences) {
        super("Main company", "", party, preferences);
    }
}
