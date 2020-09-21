package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class Party {
    private PartyId partyId;
    private List<Address> addresses;
    private List<RegisteredIdentifier> identifier;
    private Set<Preference> preferences;


    abstract String getName();


}
