package com.pz.reservoir.relationship.roles;

import com.pz.reservoir.party.Party;
import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.party.Person;
import com.pz.reservoir.relationship.PartyRoleType;

public class VehicleOwner extends PartyRoleType {

    @Override
    public boolean canPlayRole(Party party) {
        return party instanceof Person;
    }
}
