package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class Employer extends PartyRole {
    public Employer(PartyId party, Set<Preference> preferences) {
        super("Workplace with employees", "company branch which can employ employees", party, preferences);
    }
}
