package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class BranchUnit extends PartyRole {
    public BranchUnit(PartyId party, Set<Preference> preferences) {
        super("Branch of larger company", "description", party, preferences);
    }
}
