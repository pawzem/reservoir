package com.pz.reservoir.party.address;

import com.pz.reservoir.party.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelecomAddress extends Address {
    private final String number;

    @Override
    public String getAddress() {
        return number;
    }
}
