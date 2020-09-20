package com.pz.reservoir.relationship;

import com.pz.reservoir.party.PartyId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PartyRole {
    private String name;
    private String description;
    private PartyId party;
    private RoleIdentifier roleIdentifier;
    private PartyRoleType partyRoleType;
}
