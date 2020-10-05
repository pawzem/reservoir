package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class VehicleOwner extends PartyRole {

    public VehicleOwner(PartyId party, Set<Preference> preferences) {
        super("owner of vehicle", "party which owns the car", party, preferences);
    }
}
