package com.pz.reservoir.party.address;

import com.pz.reservoir.party.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailAddress extends Address {
    private final String email;

    @Override
    public String getAddress() {
        return email;
    }
}
