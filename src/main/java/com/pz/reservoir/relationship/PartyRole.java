package com.pz.reservoir.relationship;

import com.pz.reservoir.party.PartyId;
import com.pz.reservoir.preference.Preference;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public abstract class PartyRole {
    private String name;
    private String description;
    private PartyId party;
    private Set<Preference> preferences;
}
