package com.pz.reservoir.preference;

import com.pz.reservoir.party.PartyId;

import java.util.UUID;

public class PreferenceIdFactory {
    public static PreferenceTypeId generate(){
        return new PreferenceTypeId(UUID.randomUUID().toString());
    }

    public static PreferenceTypeId of(String partyId){
        return new PreferenceTypeId(UUID.fromString(partyId).toString());
    }


}
