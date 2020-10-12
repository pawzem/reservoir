package com.pz.reservoir.party;

import com.pz.reservoir.preference.Preference;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class Car extends Party{

    private final String carType;
    private final String name;

    Car(PartyId partyId, List<Address> addresses, List<RegisteredIdentifier> identifier, Set<Preference> preferences,String name,String carType) {
        super(partyId, addresses, identifier, preferences);
        this.carType = carType;
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }
}
