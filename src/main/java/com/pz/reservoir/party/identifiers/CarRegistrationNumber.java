package com.pz.reservoir.party.identifiers;

import com.pz.reservoir.party.RegisteredIdentifier;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarRegistrationNumber extends RegisteredIdentifier {

    private final String carRegistrationNumber;

    @Override
    public String getIdentifier() {
        return carRegistrationNumber;
    }
}
