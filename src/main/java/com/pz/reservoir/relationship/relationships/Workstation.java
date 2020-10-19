package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class Workstation  extends PartyRole {
    public Workstation(PartyId party, Set<Preference> preferences) {
        super("Workstation", "Workstation placed in organization tnit", party, preferences);
    }
}
