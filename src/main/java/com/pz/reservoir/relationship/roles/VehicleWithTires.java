package com.pz.reservoir.relationship.roles;

import com.pz.reservoir.client.dto.TireStorage;
import com.pz.reservoir.party.Car;
import com.pz.reservoir.party.Party;
import com.pz.reservoir.preference.Preference;
import com.pz.reservoir.relationship.PartyRoleType;

public class VehicleWithTires extends PartyRoleType {

    @Override
    public boolean canPlayRole(Party party) {
        return party instanceof Car && party.getPreferences().stream().noneMatch(preference -> TireStorage.ABSENT.name().equals(preference.getOptionName()));
    }
}
