package com.pz.reservoir.party.address;

import com.pz.reservoir.party.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhysicalAddress extends Address {
    private final String address;

    @Override
    public String getAddress() {
        return address;
    }
}
