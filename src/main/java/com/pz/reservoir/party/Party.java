package com.pz.reservoir.party;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class Party {
    private PartyId partyId;
    private List<Address> addresses;
    private List<RegisteredIdentifier> identifier;


    abstract String getName();


}
