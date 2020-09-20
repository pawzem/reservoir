package com.pz.reservoir.party;

import java.util.List;

public class Company extends Organization{


    Company(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier) {
        super(partyId, addresses, identifier);
    }

}
