package com.pz.reservoir.relationship.relationships;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRole;

import java.util.Set;

public class UnitWithWorkstations extends PartyRole {
    public UnitWithWorkstations(PartyId party, Set<Preference> preferences) {
        super("Unit with workstations", "branch unit which can contain worksations", party, preferences);
    }
}
