package com.pz.reservoir.party;

import java.util.UUID;

public class PartyIdFactory {
    PartyId generate(){
        return new PartyId(UUID.randomUUID().toString());
    }

    PartyId of(String partyId){
        return new PartyId(UUID.fromString(partyId).toString());
    }


}
