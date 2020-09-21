package com.pz.reservoir.party;

import java.util.UUID;

public class PartyIdFactory {
    static PartyId generate(){
        return new PartyId(UUID.randomUUID().toString());
    }

    public static PartyId of(String partyId){
        return new PartyId(UUID.fromString(partyId).toString());
    }


}
