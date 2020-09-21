package com.pz.reservoir.party;

import java.util.UUID;

class PartyIdFactory {
    static PartyId generate(){
        return new PartyId(UUID.randomUUID().toString());
    }

    static PartyId of(String partyId){
        return new PartyId(UUID.fromString(partyId).toString());
    }


}
