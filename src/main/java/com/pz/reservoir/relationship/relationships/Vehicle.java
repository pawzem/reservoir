package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class Vehicle extends PartyRole {

    public Vehicle(PartyId party, Set<Preference> preferences) {
        super("Vehicle", "", party, preferences);
    }

}
