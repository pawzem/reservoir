package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class Employee extends PartyRole {
    public Employee(PartyId party, Set<Preference> preferences) {
        super("Employee", "employee working in given branch", party, preferences);
    }
}
